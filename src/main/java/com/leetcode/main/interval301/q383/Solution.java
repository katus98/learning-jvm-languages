package com.leetcode.main.interval301.q383;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
public class Solution {
    /**
     * 哈希表统计数量
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
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
