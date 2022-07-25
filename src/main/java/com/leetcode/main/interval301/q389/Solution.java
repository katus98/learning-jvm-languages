package com.leetcode.main.interval301.q389;

/**
 * 找不同
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution {
    /**
     * 长字符串每个字符之和减去短字符串每个字符得到的数值强转为char
     */
    public char findTheDifference(String s, String t) {
        long sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return (char) sum;
    }
}
