package com.highkgao.voteweb.util;

import javax.servlet.http.HttpSession;

public class WebUtil {

    public static boolean getSessionBooleanValue(String sessionKey, HttpSession httpSession) {
        Object o = httpSession.getAttribute(sessionKey);
        if (o instanceof Boolean) {
            return ((Boolean) o).booleanValue();
        }
        return false;
    }
}
