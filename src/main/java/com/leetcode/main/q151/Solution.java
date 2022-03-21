package com.leetcode.main.q151;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 * @see com.leetcode.offer.q58.Solution
 */
public class Solution {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]).append(" ");
        }
        return builder.toString().trim();
    }
}
