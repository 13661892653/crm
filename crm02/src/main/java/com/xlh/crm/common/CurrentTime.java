package com.xlh.crm.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ysl on 2017/3/21.
 */
public class CurrentTime {

    //系统当前时间，Int型到秒的时间戳
    public static Integer getSecondTimestamp() {
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()/1000);
        int returnSecond = Integer.valueOf(timestamp);
        return returnSecond;
    }

    //系统当前时间，字符串格式
    public static String getCurrentTime() {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }

    //前一天，字符串格式
    public static String getLastDay() {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = df.format(date);
        return returnStr;
    }

    //7天前，字符串格式
    public static String getLast7Day() {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7); //得到7天前
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = df.format(date);
        return returnStr;
    }

    //15天前，字符串格式
    public static String getLast15Day() {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -15); //得到15天前
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = df.format(date);
        return returnStr;
    }

    //30天前，字符串格式
    public static String getLast30Day() {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -30); //得到30天前
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = df.format(date);
        return returnStr;
    }

    //60天前，字符串格式
    public static String getLast60Day() {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -60); //得到60天前
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = df.format(date);
        return returnStr;
    }

    //获取系统当天是星期几
    public static int getDayOfWeek() {
        int week = 0;
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
            week = 7;
        }else{
            week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return week;
    }

}
