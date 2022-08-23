package com.leetcode.main.interval401.q459;

/**
 * 重复的子字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-23
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
