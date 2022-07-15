package com.leetcode.main.interval201.q205;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Solution {
    /**
     * 双重映射
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (map1.containsKey(ch1)) {
                if (map1.get(ch1) != ch2) return false;
            } else {
                map1.put(ch1, ch2);
            }
            if (map2.containsKey(ch2)) {
                if (map2.get(ch2) != ch1) return false;
            } else {
                map2.put(ch2, ch1);
            }
        }
        return true;
    }
}
