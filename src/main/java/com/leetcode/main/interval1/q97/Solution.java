package com.leetcode.main.interval1.q97;

/**
 * 交错字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    /**
     * DP 表示s1前i个字符与s2前j个字符能否构成s3前i + j个字符
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 回溯: 漂亮的超时了
     */
    private boolean isFit(String s1, String s2, String s3, int i1, int i2, int i) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }
        char ch = s3.charAt(i);
        if (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) == ch && isFit(s1, s2, s3, i1 + 1, i2, i + 1)) {
                return true;
            }
            return s2.charAt(i2) == ch && isFit(s1, s2, s3, i1, i2 + 1, i + 1);
        }
        if (i1 < s1.length()) {
            if (s1.charAt(i1) == ch) return isFit(s1, s2, s3, i1 + 1, i2, i + 1);
            else return false;
        } else {
            if (s2.charAt(i2) == ch) return isFit(s1, s2, s3, i1, i2 + 1, i + 1);
            else return false;
        }
    }
}
