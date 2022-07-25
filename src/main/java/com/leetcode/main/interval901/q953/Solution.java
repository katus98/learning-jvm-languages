package com.leetcode.main.interval901.q953;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证外星语词典
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(orderMap, words[i], words[i + 1]) > 0) return false;
        }
        return true;
    }

    private int compare(Map<Character, Integer> orderMap, String s1, String s2) {
        int i;
        for (i = 0; i < s1.length() && i < s2.length(); i++) {
            int c = orderMap.get(s1.charAt(i)) - orderMap.get(s2.charAt(i));
            if (c != 0) {
                return c;
            }
        }
        return s1.length() - s2.length();
    }
}
