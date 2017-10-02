package com.highkgao.voteweb.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public String sendRedirect(HttpServletResponse response,String link) {
        try {
            response.sendRedirect(link);
            return link;
        } catch (Exception e) {
            LOGGER.error("重定向异常",e);
        }
        return link;

    }

}
