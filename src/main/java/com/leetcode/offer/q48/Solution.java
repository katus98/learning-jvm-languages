package com.leetcode.offer.q48;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 * @see com.leetcode.main.interval1.q3.Solution
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = s.length(), maxLength = 0;
        StringBuilder builder = new StringBuilder();
        String current = "";
        for (int j = 0; j < length; j++) {
            if (current.contains(String.valueOf(chars[j]))) {
                builder.delete(0, current.lastIndexOf(chars[j]) + 1);
            }
            builder.append(chars[j]);
            current = builder.toString();
            maxLength = Math.max(maxLength, current.length());
        }
        return maxLength;
    }
}
