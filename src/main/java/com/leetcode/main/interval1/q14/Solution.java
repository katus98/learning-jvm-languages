package com.leetcode.main.interval1.q14;

/**
 * 最长公共前缀
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        char[] preChs = strs[0].toCharArray();
        int end = preChs.length;
        for (int i = 1; i < strs.length; i++) {
            end = Math.min(end, strs[i].length());
            if (end == 0) break;
            for (int j = 0; j < end; j++) {
                if (strs[i].charAt(j) != preChs[j]) {
                    end = j;
                    break;
                }
            }
        }
        return String.valueOf(preChs, 0, end);
    }
}
