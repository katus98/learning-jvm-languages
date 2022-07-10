package com.leetcode.main.interval301.q392;

/**
 * 判断子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
public class Solution {
    /**
     * 双指针
     */
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t)) return true;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (k < t.length() && ch != t.charAt(k)) {
                k++;
            }
            if (k == t.length()) return false;
            k++;
        }
        return true;
    }
}
