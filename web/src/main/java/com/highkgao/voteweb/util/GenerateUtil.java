package com.highkgao.voteweb.util;

import java.util.Random;

public class GenerateUtil {

    /**
     * 获取唯一Id
     */
    public static String generateUniqueId() {
        String random = String.valueOf(System.currentTimeMillis() + String.valueOf(new Random().nextInt()));
        if (random.length() > 20) {
            return random.substring(0,20);
        }
        return random;
    }
}
