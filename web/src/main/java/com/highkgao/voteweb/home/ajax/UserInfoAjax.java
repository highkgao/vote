package com.highkgao.voteweb.home.ajax;

import com.highkgao.voteCommon.ResultCode;
import com.highkgao.votedb.UserInfo;
import com.highkgao.votedb.UserInfoMapper;
import com.highkgao.voteweb.base.BaseAjax;
import com.highkgao.voteweb.contants.SessionContants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by gaofeng on 17/9/3.
 */
@Controller
@RequestMapping(value = "user")
public class UserInfoAjax extends BaseAjax {

    @Resource
    UserInfoMapper userInfoMapper;

    @RequestMapping(value = "queryUser.json", method = RequestMethod.GET)
    public void queryUserAjax(ModelMap modelMap, String userNo) {
        // 查询db
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1L);
        fillSuccess(modelMap, userInfo);
    }


    @RequestMapping(value = "loginOut.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void loginOut(ModelMap modelMap, HttpSession session) {
        session.removeAttribute(SessionContants.LOGON_NAME);
        fillSuccess(modelMap);
    }

    // 登录请求
    @RequestMapping(value = "login.json", method = {RequestMethod.POST})
    public void login(String logonId, String password, HttpSession session, ModelMap modelMap) {
        UserInfo userInfo = userInfoMapper.selectByLogonId(logonId);
        if (userInfo == null) {
            fillError(modelMap, ResultCode.ACCOUNT_NOT_EXSIT);
            return;
        }
        if (!StringUtils.equals(password, userInfo.getPassword())) {
            fillError(modelMap, ResultCode.LOGON_PASSWORD_ERROR);
            return;
        }
        session.setAttribute(SessionContants.LOGON_ID, logonId);
        session.setAttribute(SessionContants.LOGON_NAME, userInfo.getUserName());
        session.setAttribute(SessionContants.LOGON_USER_ID, userInfo.getUserId());
        fillSuccess(modelMap);
    }




}
