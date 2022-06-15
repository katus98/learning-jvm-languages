package com.leetcode.main.interval401.q438;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-15
 */
public class Solution {
    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        if (s.length() < p.length()) return resList;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> wordMap = new HashMap<>();
        int i = 0, j = p.length() - 1;
        for (int k = 0; k < p.length(); k++) {
            char ch = s.charAt(k);
            wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
        }
        if (check(map, wordMap)) {
            resList.add(0);
        }
        while (j + 1 < s.length()) {
            char c1 = s.charAt(i);
            wordMap.put(c1, wordMap.get(c1) - 1);
            if (wordMap.get(c1) == 0) {
                wordMap.remove(c1);
            }
            i++;
            char c2 = s.charAt(j + 1);
            wordMap.put(c2, wordMap.getOrDefault(c2, 0) + 1);
            j++;
            if (check(map, wordMap)) {
                resList.add(i);
            }
        }
        return resList;
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> map1) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            if (!map1.containsKey(key) || !entry.getValue().equals(map1.get(key))) {
                return false;
            }
        }
        return true;
    }
}
