package com.katus.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
public class OtherClassTest {
    @Test
    public void testSystem() {
        long timeMillis = System.currentTimeMillis();   // 获取当前时间戳
        System.out.println(timeMillis);

        System.gc();   // 提醒系统进行垃圾回收

        System.out.println(System.getProperty("java.version"));   // 获取Java相关属性
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        System.exit(0);   // 退出程序
    }

    @Test
    public void testNumber() {
        BigInteger bigInteger = new BigInteger("123457894561234567894561234564897845615348971234845451123");
        System.out.println(bigInteger);

        BigDecimal bd = new BigDecimal("123.456789");
        BigDecimal bd2 = new BigDecimal("11.4");
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
    }
}
