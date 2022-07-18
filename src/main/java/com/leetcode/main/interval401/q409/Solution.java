package com.leetcode.main.interval401.q409;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-18
 */
public class Solution {
    /**
     * 哈希表统计数量
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int c = entry.getValue();
            count += c / 2;
        }
        count *= 2;
        return s.length() > count ? count + 1 : count;
    }
}
