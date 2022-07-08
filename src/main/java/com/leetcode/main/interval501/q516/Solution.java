package com.leetcode.main.interval501.q516;

/**
 * 最长回文子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-08
 */
public class Solution {
    /**
     * DP 表示[i, j]最长回文序列长度
     * d2DP: dp[i][j] = dp[i + 1][j - 1] + 2 (s[i]==s[j])
     * d2DP: dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) (s[i]!=s[j])
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char ch1 = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
