package com.leetcode.main.interval401.q415;

/**
 * 字符串相加
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-19
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        char ch1, ch2, front = '\0';
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            if (i < num1.length()) {
                ch1 = num1.charAt(num1.length() - 1 - i);
            } else {
                ch1 = '0';
            }
            if (i < num2.length()) {
                ch2 = num2.charAt(num2.length() - 1 - i);
            } else {
                ch2 = '0';
            }
            char res = (char) (ch1 + ch2 - '0' + front);
            if (res > '9') {
                res -= 10;
                front = '\1';
            } else {
                front = '\0';
            }
            builder.insert(0, res);
        }
        if (front == '\1') {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
