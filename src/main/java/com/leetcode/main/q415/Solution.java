package com.leetcode.main.q415;

/**
 * 字符串相加
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-19
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        char front = '\0', ch1, ch2, ch;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            if (i < num1.length()) {
                ch1 = num1.charAt(num1.length() - i - 1);
            } else {
                ch1 = '0';
            }
            if (i < num2.length()) {
                ch2 = num2.charAt(num2.length() - i - 1);
            } else {
                ch2 = '0';
            }
            ch = (char) (ch1 - '0' + ch2 + front);
            if (ch > '9') {
                ch = (char) (ch - 10);
                front = '\1';
            } else {
                front = '\0';
            }
            builder.insert(0, ch);
        }
        if (front == '\1') {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
