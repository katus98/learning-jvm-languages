package com.leetcode.offer.q20;

import org.junit.jupiter.api.Test;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {

    public boolean isNumber(String s) {
        // 不能为空
        if (s == null) return false;
        s = s.trim().toLowerCase();
        // 不能只有空格
        if (s.isEmpty()) return false;
        int numE = 0, numPoint = 0, numSymbol = 0, indexE = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'e') {
                // 记录e出现的数量和位置
                numE++;
                indexE = i;
                // e不能出现在首尾
                if (i == 0 || i == s.length() - 1) {
                    return false;
                }
                // e前面只能是数字或者点; e后面只能是数字或者符号
                if (!isDigitalOrPoint(s.charAt(i - 1)) && !isDigitalOrSymbol(s.charAt(i + 1))) {
                    return false;
                }
            } else if (ch == '.') {
                // 记录点出现的数量
                numPoint++;
                // 点不能是唯一的元素
                if (s.length() == 1) {
                    return false;
                }
                // 点在首位时必须要紧接数字
                if (i == 0 && !isDigital(s.charAt(i + 1))) {
                    return false;
                }
                // 点在末位时必须要前面接数字
                if (i == s.length() - 1 && !isDigital(s.charAt(i - 1))) {
                    return false;
                }
                // 点在中间时, 前面或者后面需要有一个紧接数字
                if ((i - 1 >= 0 && !isDigital(s.charAt(i - 1))) && (i + 1 < s.length() && !isDigital(s.charAt(i + 1)))) {
                    return false;
                }
                // 点不能出现在e的后面
                if (i > indexE) {
                    return false;
                }
            } else if (isMinusSymbol(ch)) {
                // 记录符号的数量
                numSymbol++;
                // 符号必须是首位或者紧接着e; 符号不能是最后一位; 符号的后面必须紧接着小数点或者数字
                if ((i != 0 && s.charAt(i - 1) != 'e') || i == s.length() - 1 || !isDigitalOrPoint(s.charAt(i + 1))) {
                    return false;
                }
            } else if (!isDigital(ch)) {
                // 不能是非法字符
                return false;
            }
        }
        // e和点最多出现一次; 符号最多出现两次
        return numE <= 1 && numPoint <= 1 && numSymbol <= 2;
    }

    private boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isMinusSymbol(char ch) {
        return ch == '+' || ch == '-';
    }

    private boolean isDigitalOrPoint(char ch) {
        return isDigital(ch) || ch == '.';
    }

    private boolean isDigitalOrSymbol(char ch) {
        return isDigital(ch) || isMinusSymbol(ch);
    }

    @Test
    public void test() {
        System.out.println(isNumber("32.e-80123"));
    }
}
