package com.leetcode.main.interval301.q387;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
public class Solution {
    /**
     * 哈希表统计数量
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (1 == map.get(ch)) {
                return i;
            }
        }
        return -1;
    }
}
