package com.highkgao.voteweb.business.ajax;

import com.highkgao.voteCommon.ResultCode;
import com.highkgao.votedb.UserInfo;
import com.highkgao.votedb.VoteItemDO;
import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.voteservice.UserService;
import com.highkgao.voteservice.VoteService;
import com.highkgao.voteweb.base.BaseAjax;
import com.highkgao.voteweb.business.form.AddVoteForm;
import com.highkgao.voteweb.business.form.ItemVO;
import com.highkgao.voteweb.contants.SessionContants;
import com.highkgao.voteweb.util.DateUtil;
import com.highkgao.voteweb.util.GenerateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserActionAjax extends BaseAjax {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionAjax.class);

    @Resource
    private VoteService voteService;

    @Resource
    private UserService userService;

    // 增加主题
    @RequestMapping(value = "addvote.json", method = {RequestMethod.POST})
    public void addVote(HttpSession session, ModelMap modelMap, @RequestBody AddVoteForm addVoteForm) {
        String logonUserId = (String) session.getAttribute(SessionContants.LOGON_USER_ID);
        if (StringUtils.isEmpty(logonUserId)) {
            fillError(modelMap, ResultCode.SESSION_OUT);
            return;
        }
        VoteThemeDO voteThemeDO = generateVoteThemeDO(addVoteForm, logonUserId);
        List<VoteItemDO> voteItemDOList = new ArrayList<VoteItemDO>(10);
        for (ItemVO itemVO : addVoteForm.getItems()) {
            voteItemDOList.add(generateVoteItemDO(itemVO, voteThemeDO.getVoteId()));
        }
        voteService.addVote(voteThemeDO, voteItemDOList);
        fillSuccess(modelMap);
    }

    /**
     * 支付宝登录授权并查询用户信息
     *
     * @param modelMap
     * @param authCode
     */
    @RequestMapping(value = "alipayUserAuthorize.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void alipayUserAuthorize(ModelMap modelMap, String authCode) {
        LOGGER.info("支付宝用户授权请求 authCode = {}", authCode);
        UserInfo userInfo = userService.alipayUserAuthorize(authCode);
        fillSuccess(modelMap, userInfo);
    }

    @RequestMapping(value = "wechatUserAuthorize.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void wechatUserAuthorize(ModelMap modelMap, String code) {
        LOGGER.info("微信用户授权请求 code ={}", code);

        fillSuccess(modelMap);

    }


    private VoteThemeDO generateVoteThemeDO(AddVoteForm addVoteForm, String userId) {
        VoteThemeDO voteThemeDO = new VoteThemeDO();
        voteThemeDO.setFinishTime(DateUtil.getDateFromString(addVoteForm.getEndTime(), DateUtil.DATE_YYYY_MM_DD_HH_MM));
        voteThemeDO.setStartTime(DateUtil.getDateFromString(addVoteForm.getStartTime(), DateUtil.DATE_YYYY_MM_DD_HH_MM));
        voteThemeDO.setGmtCreate(new Date());
        voteThemeDO.setGmtModified(new Date());
        voteThemeDO.setTheme(addVoteForm.getTheme());
        voteThemeDO.setUserId(userId);
        voteThemeDO.setVoteId(GenerateUtil.generateUniqueId());
        return voteThemeDO;
    }

    private VoteItemDO generateVoteItemDO(ItemVO itemVO, String voteId) {
        VoteItemDO voteItemDO = new VoteItemDO();
        voteItemDO.setItemDesc(itemVO.getItemDesc());
        voteItemDO.setItemId(GenerateUtil.generateUniqueId());
        voteItemDO.setItemName(itemVO.getItemName());
        voteItemDO.setPicUrl(itemVO.getItemPic());
        voteItemDO.setSuperiority(itemVO.getItemSuperiority());
        voteItemDO.setVoteId(voteId);
        voteItemDO.setCount(0);
        voteItemDO.setGmtCreate(new Date());
        voteItemDO.setGmtModified(new Date());
        return voteItemDO;
    }

    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }
}
