package com.leetcode.main.interval1.q43;

/**
 * 字符串相乘
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-08
 */
public class Solution {
    /**
     * 列竖式
     *
     * @see com.leetcode.main.interval401.q415.Solution
     */
    public String multiply(String num1, String num2) {
        // 调用字符串加法算法
        com.leetcode.main.interval401.q415.Solution solution = new com.leetcode.main.interval401.q415.Solution();
        String result = "0";
        for (int i = 0; i < num1.length(); i++) {
            char n1 = num1.charAt(num1.length() - 1 - i);
            for (int j = 0; j < num2.length(); j++) {
                char n2 = num2.charAt(num2.length() - 1 - j);
                String temp = appendZero(multiply(n1, n2), i + j);
                result = solution.addStrings(result, temp);
            }
        }
        return result;
    }

    private String multiply(char n1, char n2) {
        return String.valueOf((n1 - '0') * (n2 - '0'));
    }

    /**
     * 当数值不为0, 向后补充count个0
     */
    private String appendZero(String num, int count) {
        // 一定不要向0后面补0
        if (num.equals("0")) return num;
        StringBuilder builder = new StringBuilder(num);
        for (int i = 0; i < count; i++) {
            builder.append('0');
        }
        return builder.toString();
    }
}
