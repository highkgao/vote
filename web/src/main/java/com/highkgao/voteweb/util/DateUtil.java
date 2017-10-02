package com.highkgao.voteweb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd hh:mm";

    public static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";

    public static Date getDateFromString(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
