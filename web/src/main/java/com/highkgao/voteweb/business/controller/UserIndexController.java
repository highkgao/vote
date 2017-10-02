package com.highkgao.voteweb.business.controller;

import com.highkgao.votedb.UserInfoMapper;
import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.votedb.VoteThemeDOMapper;
import com.highkgao.voteweb.base.BaseController;
import com.highkgao.voteweb.contants.SessionContants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户主要操作页面
 */
@Controller
@RequestMapping(value = "user")
public class UserIndexController extends BaseController{



    @Resource
    VoteThemeDOMapper voteThemeDOMapper;


    // 个人主页
    @RequestMapping(value = "index.htm")
    public String index(ModelMap modelMap, HttpSession session) {
        String logonUserId = (String)session.getAttribute(SessionContants.LOGON_USER_ID);
        if (StringUtils.isEmpty(logonUserId)) {
            throw new RuntimeException("this page need logon");
        }

        return "/user/index.vm";
    }

    @RequestMapping(value = "addvote.htm")
    public String addVote(ModelMap modelMap, HttpSession session) {
        return "/user/addvote.vm";
    }


}
