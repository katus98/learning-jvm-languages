package com.nx.vip.jvm.bytecode;

/**
 * 测试不同的字符串拼接方法在编译之后的差异
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-04
 */
public class StringTest {
    /**
     * JDK 1.8 编译后会将字符串拼接转化为StringBuilder,
     * 但是会在循环中创建, 创建循环次数
     */
    public static void m1() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = str + "nx,";
        }
        System.out.println(str);
    }

    /**
     * 循环前创建StringBuffer
     */
    public static void m2() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            str.append("nx,");
        }
        System.out.println(str);
    }

    public static String m3() {
        String str = "hello";
        try {
            return str;
        } finally {
            str = "nx";
        }
    }
}
