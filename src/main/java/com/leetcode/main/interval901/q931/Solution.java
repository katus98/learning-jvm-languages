package com.leetcode.main.interval901.q931;

/**
 * 下降路径最小和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-04
 */
public class Solution {
    /**
     * DP 以当前元素结尾的最小路径和
     * d2DP: dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1], dp[i - 1][j - 1])
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + (dp[i - 1][j - 1] > dp[i - 1][j + 1] ?
                            Math.min(dp[i - 1][j], dp[i - 1][j + 1]) :
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
                if (i == n - 1 && res > dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }
}
