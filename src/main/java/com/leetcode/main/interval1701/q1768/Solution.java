package com.leetcode.main.interval1701.q1768;

/**
 * 交替合并字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(j));
            i++;
            j++;
        }
        if (i < word1.length()) {
            builder.append(word1, i, word1.length());
        } else {
            builder.append(word2, j, word2.length());
        }
        return builder.toString();
    }
}
