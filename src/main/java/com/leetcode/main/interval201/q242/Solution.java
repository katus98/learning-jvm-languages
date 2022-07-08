package com.leetcode.main.interval201.q242;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
public class Solution {
    /**
     * 哈希表统计数量
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) return false;
            int count = map.get(ch);
            if (count == 1) {
                map.remove(ch);
            } else {
                map.put(ch, count - 1);
            }
        }
        return true;
    }
}
