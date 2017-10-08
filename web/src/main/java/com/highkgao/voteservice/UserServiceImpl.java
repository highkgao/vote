package com.highkgao.voteservice;

import com.highkgao.thirdservice.alipay.AlipayUserService;
import com.highkgao.thirdservice.alipay.ThirdUserInfoModel;
import com.highkgao.votedb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserServiceImpl implements UserService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 用户dao层
     */
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 支付宝授权服务
     */
    @Resource
    private AlipayUserService alipayUserService;

    /**
     * 第三方登录信息的dao
     */
    @Resource
    private ThirdUserInfoDOMapper thirdUserInfoDOMapper;

    /**
     * 事务管理
     */
    @Resource
    TransactionTemplate voteTransactionTemplate;

    /**
     * @see UserService#registerUser(String, String, String)
     */
    public UserInfo registerUser(String account, String name, String md5password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        userInfo.setPassword(md5password);
        userInfo.setStatus(UserStatusEnum.Valid.getStatus());
        userInfo.setUserId(generatorUserNo());
        userInfo.setEmail(account);
        userInfo.setLogonId(account);
        userInfoMapper.insert(userInfo);
        return userInfo;
    }

    /**
     * @see UserService#alipayUserAuthorize(String)
     */
    public UserInfo alipayUserAuthorize(String authCode) {
        final ThirdUserInfoModel thirdUserInfoModel = alipayUserService.alipayUserAuthorize(authCode);

        if (thirdUserInfoModel == null) {
            LOGGER.warn("获取支付宝信息失败");
            throw new RuntimeException("获取用户支付宝信息失败");
        }
        LOGGER.info("用户的支付宝信息 userInfo ={}", thirdUserInfoModel);

        ThirdUserInfoDO thirdUserInfoDO = thirdUserInfoDOMapper.selectByUserIdAndChannel(thirdUserInfoModel.getUserIdThird(), thirdUserInfoModel.getUserIdChannel());

        UserInfo userInfo = null;
        // 如果没有数据，则新建一个匿名用户
        if (thirdUserInfoDO == null) {
            final UserInfo anonymousUser = generatorAnonymousUser(thirdUserInfoModel.getNikeName());
            userInfo = anonymousUser;
            boolean isAddSuccess = voteTransactionTemplate.execute(new TransactionCallback<Boolean>() {
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    try {
                        ThirdUserInfoDO thirdUserInfoDO = convertToThirdUserInfoDO(thirdUserInfoModel, anonymousUser.getUserId());
                        thirdUserInfoDOMapper.insert(thirdUserInfoDO);
                    } catch (Exception e) {
                        transactionStatus.setRollbackOnly();
                        LOGGER.error("创建三方用户失败", e);
                        return false;
                    }
                    return true;
                }
            });
            // 如果增加失败，则报错
            if (!isAddSuccess) {
                LOGGER.warn("绑定用户失败 thirdUserInfo = {}", thirdUserInfoModel);
                throw new RuntimeException("绑定用户失败");
            }
        } else {
            userInfo = userInfoMapper.selectByUserId(thirdUserInfoDO.getRelationOwnerUserId());
        }

        return userInfo;
    }


    /**
     * 生成一个匿名用户
     *
     * @return
     */
    private UserInfo generatorAnonymousUser(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(generatorUserNo());
        userInfo.setUserName(name);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        userInfo.setStatus(UserStatusEnum.Valid.getStatus());
        userInfoMapper.insert(userInfo);
        return userInfo;
    }

    /**
     * 生成与用户userId
     *
     * @return
     */
    private String generatorUserNo() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDhhmmss");
        return sdf.format(calendar.getTime());
    }

    /**
     * convert成 ThirdUserInfoDO
     *
     * @param thirdUserInfoModel {@link ThirdUserInfoModel}
     * @return {@link ThirdUserInfoDO}
     */
    private ThirdUserInfoDO convertToThirdUserInfoDO(ThirdUserInfoModel thirdUserInfoModel, String relationOwnerId) {
        ThirdUserInfoDO thirdUserInfoDO = new ThirdUserInfoDO();
        thirdUserInfoDO.setAvatar(thirdUserInfoModel.getAvatar());
        thirdUserInfoDO.setCity(thirdUserInfoModel.getCity());
        thirdUserInfoDO.setGender(thirdUserInfoModel.getGender());
        thirdUserInfoDO.setIsCertified(thirdUserInfoModel.getIsCertified());
        thirdUserInfoDO.setNikeName(thirdUserInfoModel.getNikeName());
        thirdUserInfoDO.setProvince(thirdUserInfoModel.getProvince());
        thirdUserInfoDO.setUserIdChannel(thirdUserInfoModel.getUserIdChannel());
        thirdUserInfoDO.setUserIdThird(thirdUserInfoModel.getUserIdThird());
        thirdUserInfoDO.setRelationOwnerUserId(relationOwnerId);
        return thirdUserInfoDO;
    }
}
