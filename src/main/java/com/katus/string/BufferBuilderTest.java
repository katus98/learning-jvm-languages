package com.katus.string;

import org.junit.jupiter.api.Test;

/**
 * StringBuffer 可变的字符串序列 线程安全 效率不高
 * StringBuilder 可变的字符串序列 线程不安全 效率高 (Java5 新特性)
 * @author SUN Katus
 * @version 1.0, 2020-08-11
 */
public class BufferBuilderTest {
    @Test
    public void test1() {
        // 初始化长度+16 扩充时长度不够则*2+2
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }

    @Test
    public void test2() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello").append(123);
        buffer.delete(5, 8);
        System.out.println(buffer);

        buffer.replace(1, 5, "appy");
        System.out.println(buffer);

        buffer.reverse();
        System.out.println(buffer);

        buffer.insert(1, "HHH");
        System.out.println(buffer);

        System.out.println(buffer.indexOf("HHH"));
        System.out.println(buffer.substring(4, 7));
    }
}
