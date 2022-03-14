package com.leetcode.main.q567;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    /**
     * 应对是否排列可以通过统计每类字符的数量, 限制数量一致时
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int i = 0, j = s1.length() - 1;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        char[] chs = s2.toCharArray();
        boolean flag = true;
        while (j < s2.length()) {
            for (int k = i; k <= j; k++) {
                if (!map1.containsKey(chs[k])) {
                    flag = false;
                    break;
                }
                map2.put(chs[k], map2.getOrDefault(chs[k], 0) + 1);
            }
            if (flag && verify(map1, map2)) {
                return true;
            }
            flag = true;
            map2.clear();
            i++;
            j++;
        }
        return false;
    }

    private boolean verify(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character character : map1.keySet()) {
            if (!map2.containsKey(character) || !map1.get(character).equals(map2.get(character))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
