package com.ripper.budding.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author shadow
 */
public class DateTest {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        // String agent=request.getHeader("User-Agent").toLowerCase();
        // System.out.println(agent);
        // System.out.println("<a
        // href="https://www.baidu.com/s?wd=%E6%B5%8F%E8%A7%88%E5%99%A8&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dWnjDdPAmYujbYuH-hmHTY0ZwV5Hcvrjm3rH6sPfKWUMw85HfYnjn4nH6sgvPsT6KdThsqpZwYTjCEQLGCpyw9Uz4Bmy-bIi4WUvYETgN-TLwGUv3EnHDknWf3PHmvPjcYPjTYPWD1rf"
        // target="_blank"
        // class="baidu-highlight">浏览器</a>版本："+getBrowserName(agent));

        // System.out.println(new Date().compareTo(DateUtils.parse("yyyyMMdd",
        // "20171101")));

        int mark = 0;
        Date stratDate = sdf.parse("2010-03-01");

        Date endDate = sdf.parse("2010-06-18");

        Date theday = sdf.parse("2010-02-01");

        if (theday.compareTo(stratDate) != -1 && theday.compareTo(endDate) != 1) {
            System.out.println("在区间范围内");
        } else {
            System.out.println("不在");
        }

    }

    public static int getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /**
     * 查询日期
     *
     * @param dBegin
     * @param dEnd
     * @return 返回list<时间段中的每天>
     */
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        // lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            lDate.add(calBegin.getTime());
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
        }
        return lDate;
    }

    /**
     * 查询日期
     *
     * @return 返回list<时间段中的每月>
     */
    public static List<Date> findMonth(Date startTime, Date endTime) {

        List<Date> lDate = new ArrayList<Date>();

        Calendar calBegin = Calendar.getInstance();// 定义日期实例

        calBegin.setTime(startTime);// 设置日期起始时间

        Calendar calEnd = Calendar.getInstance();

        calEnd.setTime(endTime);

        while (endTime.after(calBegin.getTime())) {// 判断是否到结束日期

            lDate.add(calBegin.getTime());

            calBegin.add(Calendar.MONTH, 1);// 进行当前日期月份加1
        }
        return lDate;
    }

    /**
     * 返回两个日期相差的天数,有一个时间为null返回-1
     *
     * @param d1 长的时间
     * @param d2 短的时间
     * @return int
     */
    public static int diff_in_date(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            return -1;
        }
        return (int) (d1.getTime() - d2.getTime()) / 86400000;
    }

}
