package com.katus.string;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-11
 */
public class StringTest {
    @Test
    public void test1() {
        // 常量存储在方法区 不会存储相同内容的常量 因此是同一内存块
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);

        s2 = "hello";   // 重新换了一块内存区域

        s2 += "?";   // 再次重新换了一块内存区域

        s2.replace('l', 'm');
        System.out.println(s2);

        // 总结 所有对字符串值的修改都会导致字符串更换内存位置 本质都是新建字符串
    }

    @Test
    public void test2() {
        String s1 = "JavaEE";   // 值存储在方法区 指向常量池
        String s2 = "JavaEE";   // 值存储在方法区 指向常量池
        String s3 = new String("JavaEE");   // 堆空间 指向 new 重新分配内存
        String s4 = new String("JavaEE");   // 堆空间 指向 new 重新分配内存
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
    }

    @Test
    public void test3() {
        // 常量与常量的拼接结果还是在常量池中
        // 只要拼接涉及到String类对象 结果指向堆空间
        String s1 = "Java";
        String s2 = "Spark";
        final String sf = "Spark";

        String s3 = "JavaSpark";   // 结果指向常量池
        String s4 = "Java" + "Spark";   // 结果指向常量池
        String s5 = s1 + "Spark";   // 结果指向堆空间
        String s6 = "Java" + s2;   // 结果指向堆空间
        String s7 = s1 + s2;   // 结果指向堆空间

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s6 == s7);

        String s8 = s5.intern();   // 返回的s8指向常量池
        System.out.println(s3 == s8);

        String sx = "Java" + sf;
        System.out.println(sx == s3);
    }

    @Test
    public void test4() {
        String str = "Nothing";
        String sx = "nothing";
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.isEmpty());   // str.length() == 0
        System.out.println(str.toLowerCase());   // 返回值本身是小写 str不变
        System.out.println(str.toUpperCase());   // 返回值本身是大写 str不变

        System.out.println(str.trim());   // 忽略前后空白
        System.out.println(str.equals(sx));
        System.out.println(str.equalsIgnoreCase(sx));

        System.out.println(str.concat(sx));   // str + sx
        System.out.println(str.compareTo(sx));   // str - sx

        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 4));

        System.out.println(str.startsWith(sx));
        System.out.println(str.startsWith(sx, 2));
        System.out.println(str.endsWith(sx));
        System.out.println(str.contains(sx));

        System.out.println(str.indexOf("thing"));
        System.out.println(str.indexOf("thing", 2));
        System.out.println(str.lastIndexOf("thing"));
        System.out.println(str.lastIndexOf("thing", 2));

        System.out.println(str.replace("th", "she"));
        System.out.println(str.replaceAll("\\s+", "he"));
        System.out.println(str.replaceFirst("\\s+", "he"));

        System.out.println(Arrays.toString(str.split("\\s")));
    }

    @Test
    public void test5() {
        String str = "hello";
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }

        char[] chars1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str1 = new String(chars1);
        System.out.println(str1);
    }

    @Test
    public void test6() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] bs = str.getBytes();   // 默认字符集编码
        System.out.println(Arrays.toString(bs));

        byte[] bs2 = str.getBytes("GBK");   // 指定字符集编码
        System.out.println(Arrays.toString(bs2));

        String utfStr = new String(bs);   // 默认字符集解码
        System.out.println(utfStr);

        String gbkStr = new String(bs2, "GBK");   // 默认字符集解码
        System.out.println(gbkStr);
    }
}
