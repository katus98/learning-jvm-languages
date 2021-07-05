package com.katus.datetime;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Java8 之前的日期时间相关 API
 * @author SUN Katus
 * @version 1.0, 2020-08-11
 */
public class DateTimeTest {
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2() {
        // 月份从0开始 星期中周日是1
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        Date date1 = new Date(1597154307758L);
        System.out.println(date1.toString());

        // java.sql.Date 是 java.util.Date 的子类
        java.sql.Date date2 = new java.sql.Date(1597154307758L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(date.getTime());
        System.out.println(date3.toString());
    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date.toString());

        String format = sdf.format(date);
        System.out.println(format);

        String str = "20-8-10 下午5:18";
        Date date1 = sdf.parse(str);
        System.out.println(date1.toString());

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf1.format(date));
    }

    @Test
    public void testCalendar() {
        // Calendar 是抽象类 getInstance() 方法构造了其子类GregorianCalendar对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.set(Calendar.DAY_OF_MONTH, 5);   // set方法会改变自身
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        Date date = calendar.getTime();
        System.out.println(date);

        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
