package com.ripper.budding.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shadow
 */
public class GetDate {
    /**
     * 获得当前时间
     */
    public static void getTheDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        System.out.println("当前时间是：" + dateFormat.format(date));
    }

    /**
     * 获取上个月的时间
     */
    public static void getBfmonthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        System.out.println("上一个月的时间： " + dateFormat.format(date));
    }

    public static void main(String[] args) {
        getTheDate();// 获得当前时间
        getBfmonthDate();// 获取上个月的时间
    }
}
