package com.leetcode.main.interval201.q290;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-06
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map2.containsKey(words[i])) {
                if (!map2.get(words[i]).equals(ch)) return false;
            } else {
                map2.put(words[i], ch);
            }
            if (map1.containsKey(ch)) {
                if (!map1.get(ch).equals(words[i])) return false;
            } else {
                map1.put(ch, words[i]);
            }
        }
        return true;
    }
}
