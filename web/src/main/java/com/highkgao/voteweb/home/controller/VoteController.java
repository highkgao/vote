package com.highkgao.voteweb.home.controller;

import com.highkgao.votedb.UserInfo;
import com.highkgao.votedb.UserInfoMapper;
import com.highkgao.voteweb.base.BaseController;
import com.highkgao.voteweb.contants.SessionContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by gaofeng on 17/9/3.
 */
@Controller
@RequestMapping(value = "home")
public class VoteController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(VoteController.class);

    @Resource
    private UserInfoMapper userInfoMapper;


    /**
     * 主页
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "index.htm")
    public String index(ModelMap modelMap, HttpSession httpSession) {
        return "home/index.vm";

    }

    @RequestMapping(value = "register.htm")
    public String register(ModelMap modelMap) {
        return "register.vm";
    }

    @RequestMapping(value = "registerSuccess.htm")
    public String registerSuccess(String account, String name, String md5password, HttpSession httpSession) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        userInfo.setPassword(md5password);
        userInfo.setStatus("Valid");
        userInfo.setUserId(generatorUserNo());
        userInfo.setEmail(account);
        userInfo.setLogonId(account);
        userInfoMapper.insert(userInfo);
        httpSession.setAttribute(SessionContants.LOGON_ID, account);
        httpSession.setAttribute(SessionContants.IS_LOGIN, true);
        httpSession.setAttribute(SessionContants.LOGON_NAME, name);
        httpSession.setAttribute(SessionContants.LOGON_USER_ID, userInfo.getUserId());
        return "redirect:index.htm";
    }

    @RequestMapping(value = "test.json")
    public void accountInfo(ModelMap modelMap, String test) {
        LOGGER.debug("test=" + test);
        modelMap.put("hello", test);
    }

    @RequestMapping(value = "testR.json")
    public void accountInfo(String test,
                            HttpServletResponse response) {
        LOGGER.debug("test=" + test);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(test);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }


    private String generatorUserNo() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDhhmmss");
        return sdf.format(calendar.getTime());
    }
}
