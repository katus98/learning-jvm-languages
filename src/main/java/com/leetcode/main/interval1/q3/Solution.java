package com.leetcode.main.interval1.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符最长子串
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    /**
     * 滑动队列, 依次从队尾插入新成员, 从队头排除不符合要求的部分
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String current = sb.toString();
            if (current.contains(String.valueOf(s.charAt(i)))) {
                sb.delete(0, current.lastIndexOf(String.valueOf(s.charAt(i))) + 1);
            }
            sb.append(s.charAt(i));
            maxLength = Math.max(maxLength, sb.length());
        }
        return maxLength;
    }

    /**
     * 为了避免使用高级API而产生高复杂度
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int nexI = map.get(ch);
                for (int k = i; k <= nexI; k++) {
                    map.remove(s.charAt(k));
                }
                i = nexI + 1;
            }
            map.put(ch, j);
            maxLength = Math.max(maxLength, map.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }
}
