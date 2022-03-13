package com.leetcode.main.q3;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
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
