package com.leetcode.main.interval401.q451;

import java.util.*;

/**
 * 根据字符出现频率排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<CharCount> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new CharCount(entry.getKey(), entry.getValue()));
        }
        list.sort((o1, o2) -> Integer.compare(o2.count, o1.count));
        StringBuilder builder = new StringBuilder();
        for (CharCount cc : list) {
            for (int i = 0; i < cc.count; i++) {
                builder.append(cc.ch);
            }
        }
        return builder.toString();
    }

    public static class CharCount {
        char ch;
        int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
