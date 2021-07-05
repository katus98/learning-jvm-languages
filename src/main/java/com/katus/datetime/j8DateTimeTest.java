package com.katus.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-11
 */
public class j8DateTimeTest {
    @Test
    public void testLocal() {
        // now() 获取当前的日期和时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of() 设置指定的时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 8, 10, 20, 23, 41);
        System.out.println(localDateTime1);

        // getXxx() 获取时间属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());

        // withXxx() 返回修改之后的时间 原来的时间不会变化
        System.out.println(localDate.withDayOfMonth(22));

        // plusXxx() 增加并返回增加后的时间 原来的时间不会变化
        System.out.println(localTime.plusHours(12));
        System.out.println(localDate.plusMonths(2));

        // minusXxx() 减小并返回减小后的时间 原来的时间不会变化
        System.out.println(localDate.minusDays(34));
        System.out.println(localDateTime.minusSeconds(555));
    }

    @Test
    public void testInstant() {
        // 获取零度经线对应的地方时
        Instant instant = Instant.now();
        System.out.println(instant);

        // 获取东八区区时
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取对应的毫秒数 从1970年初到此
        System.out.println(instant.toEpochMilli());

        // 构造指定时间
        Instant thatTime = Instant.ofEpochMilli(1597161495905L);
        System.out.println(thatTime);
    }

    @Test
    public void testDateTimeFormatter() {
        // 第一种时间格式
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(isoDateTime.format(localDateTime));

        TemporalAccessor parse = isoDateTime.parse("2020-08-12T00:04:55.223");
        System.out.println(parse);

        // 第二种时间格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(localDateTime);
        System.out.println(formatter1.format(localDateTime));

        // 自定义时间格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter2.format(localDateTime));

        TemporalAccessor parse1 = formatter2.parse("2020-08-12 12:12:36");
        System.out.println(parse1);
    }
}
