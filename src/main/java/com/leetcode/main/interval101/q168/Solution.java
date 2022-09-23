package com.leetcode.main.interval101.q168;

/**
 * Excel表列名称
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-23
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        int num = columnNumber;
        while (num > 0) {
            num--;
            int c = num % 26;
            builder.insert(0, (char) ('A' + c));
            num /= 26;
        }
        return builder.toString();
    }
}
