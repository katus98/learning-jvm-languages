package com.leetcode.main.interval701.q720;

import java.util.Arrays;

/**
 * 词典中最长的单词
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        boolean[] dp = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 1) {
                dp[i] = true;
            } else {
                String leftWord = words[i].substring(0, words[i].length() - 1);
                for (int j = i - 1; j >= 0 && words[j].length() >= leftWord.length(); j--) {
                    if (words[j].equals(leftWord)) {
                        dp[i] = dp[j];
                        break;
                    }
                }
            }
            if (dp[i] && res.length() < words[i].length()) {
                res = words[i];
            }
        }
        return res;
    }
}
