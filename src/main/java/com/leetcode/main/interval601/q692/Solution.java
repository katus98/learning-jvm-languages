package com.leetcode.main.interval601.q692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频单词
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-28
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : map.keySet()) {
            resList.add(word);
        }
        resList.sort((o1, o2) -> {
            int c = -Integer.compare(map.get(o1), map.get(o2));
            return c == 0 ? o1.compareTo(o2) : c;
        });
        return resList.subList(0, k);
    }
}
