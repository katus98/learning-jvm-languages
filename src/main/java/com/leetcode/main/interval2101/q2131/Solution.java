package com.leetcode.main.interval2101.q2131;

import java.util.HashMap;
import java.util.Map;

/**
 * 连接两字母单词得到的最长回文串
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-04
 */
public class Solution {
    public int longestPalindrome(String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String cp = new String(new char[]{word.charAt(1), word.charAt(2)});
            if (map.containsKey(cp)) {
                int c = map.get(cp);
                if (c == 1) {
                    map.remove(cp);
                } else {
                    map.put(cp, c - 1);
                }
                count += 4;
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                count += 2;
                break;
            }
        }
        return count;
    }
}
