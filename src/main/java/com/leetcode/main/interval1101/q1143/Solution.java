package com.leetcode.main.interval1101.q1143;

/**
 * 最长公共子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 */
public class Solution {
    /**
     * d2DP
     * dp[i][j] text1前i个字符和text2前j个字符的最长公共子序列, i j只要有一个是0, dp=0
     * 当第i个text1字符等于第j个text2字符时, dp[i][j] = dp[i - 1][j - 1] + 1;
     * 如果不相等, dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
