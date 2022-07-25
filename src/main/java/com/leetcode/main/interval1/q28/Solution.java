package com.leetcode.main.interval1.q28;

/**
 * 实现 strStr()
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }
}
