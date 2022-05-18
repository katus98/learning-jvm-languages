package com.leetcode.main.q72;

/**
 * 编辑距离
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-18
 */
public class Solution {
    /**
     * 二维DP
     * dp[i][j] 表示两个单词的前i和前j个字母组成的单词的编辑距离
     * 当i或者j为0时, dp的数值等于另一个不为0的索引值
     * dp[i][j] = left < down ? Math.min(left, ld) : Math.min(down, ld);
     * dp的值是由左侧、下侧和左下侧的数值决定的, 左侧和下侧都是通过插入删除元素实现, 因此必然+1, 左下侧是通过替换元素来实现, 如果下一位恰好相等, 就不需要+1了
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int ld = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    ld += 1;
                }
                dp[i][j] = left < down ? Math.min(left, ld) : Math.min(down, ld);
            }
        }
        return dp[m][n];
    }
}
