package com.leetcode.offer.q50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 */
public class Solution {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
