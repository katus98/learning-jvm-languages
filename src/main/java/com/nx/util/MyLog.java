package com.nx.util;

import java.util.Date;

/**
 * 自定义日志输出
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-15
 */
public final class MyLog {

    public static void info(String msg) {
        System.out.printf("%s - [%s] - %s\n", new Date(), Thread.currentThread().getName(), msg);
    }
}
