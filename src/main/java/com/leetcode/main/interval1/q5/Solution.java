package com.leetcode.main.interval1.q5;

/**
 * 最长回文子串
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-14
 */
public class Solution {
    private int length;

    /**
     * 中心扩散法
     */
    public String longestPalindrome(String s) {
        this.length = s.length();
        String result = "";
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; isValid(i - j) && isValid(i + j) && s.charAt(i - j) == s.charAt(i + j); j++) {
                if (2 * j + 1 > count) {
                    result = s.substring(i - j, i + j + 1);
                    count = 2 * j + 1;
                }
            }
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; isValid(i - j) && isValid(i + j + 1) && s.charAt(i - j) == s.charAt(i + j + 1); j++) {
                if (2 * j + 2 > count) {
                    result = s.substring(i - j, i + j + 2);
                    count = 2 * j + 2;
                }
            }
        }
        return result;
    }

    /**
     * DP
     * d2DP: dp[i][j] = dp[i + 1][j - 1]
     */
    public String longestPalindrome2(String s) {
        this.length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxSize = 1, start = 0, end = 0;
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = i + len - 1;
                if (j >= length) break;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (len > maxSize && dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private boolean isValid(int index) {
        return index >= 0 && index < length;
    }
}
