package com.leetcode.main.interval601.q647;

/**
 * 回文子串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-29
 * @see com.leetcode.main.interval1.q5.Solution
 */
public class Solution {
    /**
     * 中心扩散法
     */
    public int countSubstrings(String s) {
        int count = 0, length = s.length();
        for (int center = 0; center < length; center++) {
            count++;
            for (int len = 1; len < length; len++) {
                if (center - len >= 0 && center + len < length && s.charAt(center - len) == s.charAt(center + len)) {
                    count++;
                } else break;
            }
        }
        for (int center = 0; center < length - 1; center++) {
            for (int len = 1; len < length; len++) {
                if (center - len + 1 >= 0 && center + len < length && s.charAt(center - len + 1) == s.charAt(center + len)) {
                    count++;
                } else break;
            }
        }
        return count;
    }
}
