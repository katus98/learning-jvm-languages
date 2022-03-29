package com.leetcode.main.q3;

/**
 * 无重复字符最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 双指针, 双指针中间的符合题意, 每次后指针向后走一位, 检查是否与旧有字符串重复, 去掉重复字符前面的部分, 循环
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }
}
