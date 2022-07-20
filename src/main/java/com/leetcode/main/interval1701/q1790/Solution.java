package com.leetcode.main.interval1701.q1790;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-20
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                if (idx1 == -1) idx1 = i;
                else if (idx2 == -1) idx2 = i;
                else return false;
            }
        }
        if (idx1 == -1) return true;
        if (idx2 == -1) return false;
        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
    }
}
