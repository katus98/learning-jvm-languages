package com.leetcode.offer.q67;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-26
 * @see com.leetcode.main.q8.Solution
 */
public class Solution {
    /**
     * 模拟
     */
    public int strToInt(String str) {
        int start = 0;
        // 去除前导空格
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                start = i;
                break;
            }
        }
        // 从第一个非空格开始遍历
        int result = 0, sign = 1;
        for (int i = start; i < str.length(); i++) {
            int ch = str.charAt(i);
            // 符号位只能是第一位, 记录下符号的正负
            if (i == start && (ch == '+' || ch == '-')) {
                sign = ch == '+' ? 1 : -1;
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                // 判断是否越上界
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                // 判断是否越下界
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + sign * num;
            } else {
                break;
            }
        }
        return result;
    }
}
