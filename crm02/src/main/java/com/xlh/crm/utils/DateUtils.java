package com.xlh.crm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wwz on 2017/3/20.
 */
public class DateUtils {

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Long getTimeStamp() {
        Date now = new Date();
        return now.getTime();
    }

    /**
     * 日期格式化输出
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String outputFormat(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return dateStr;
    }

}
