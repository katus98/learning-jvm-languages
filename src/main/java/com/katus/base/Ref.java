package com.katus.base;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-02
 */
public class Ref {
    public static void main(String[] args) {
        int a = 5;
        Integer b = 5;
        System.out.println(a == b);
        System.out.println(b == a);
        Integer c = 6;
        Integer d = 6;
        System.out.println(c == d);
        // 常量池区间 [-128,127]
        Integer e = -129;
        Integer f = -129;
        System.out.println(e == f);
    }
}
