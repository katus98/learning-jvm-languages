package com.leetcode.main.q76;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-24
 */
public class Solution {
    /**
     * 滑动窗口: 两个指针指向当前的子串首尾, 从后面每次放入一个, 如果当前的子串符合要求则从前到后逐位删除字符直至不符合要求
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) return "";
        int minL = -10 - s.length(), minR = -1;
        LinkedHashMap<Character, CharCount> map = new LinkedHashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            CharCount charCount = map.getOrDefault(ch, new CharCount(0, 0));
            charCount.require += 1;
            map.put(ch, charCount);
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            // 每次从后放入一个字符
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.get(ch).count++;
            }
            j++;
            while (j - i >= t.length() && isValid(map)) {
                // 如果当前窗口内符合条件
                if (j - i < minR - minL) {
                    // 如果当前窗口最小, 记录一下
                    minL = i;
                    minR = j;
                }
                // 从窗口的最左侧删除字符
                char ch2 = s.charAt(i);
                if (map.containsKey(ch2)) {
                    map.get(ch2).count--;
                }
                i++;
            }
        }
        return minR < 0 ? "" : s.substring(minL, minR);
    }

    private boolean isValid(LinkedHashMap<Character, CharCount> map) {
        for (Map.Entry<Character, CharCount> entry : map.entrySet()) {
            CharCount charCount = entry.getValue();
            if (charCount.count < charCount.require) {
                return false;
            }
        }
        return true;
    }

    public static class CharCount {
        int count;
        int require;

        public CharCount(int count, int require) {
            this.count = count;
            this.require = require;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
    }
}
