package com.leetcode.main.interval501.q583;

/**
 * 两个字符串的删除操作
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public class Solution {
    /**
     * d2DP
     * dp[i][j] 字符串1前i项和字符串2前j项形成同样字符串需要删除的操作数
     * 如果下一项两者相同 dp[i][j] = dp[i - 1][j - 1]
     * 如果下一项两者不同 dp[i][j] = 左侧+1 下侧+1 左下侧+2 三者最小值
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[m][n];
    }
}
