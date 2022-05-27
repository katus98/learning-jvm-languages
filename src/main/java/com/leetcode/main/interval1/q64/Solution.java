package com.leetcode.main.interval1.q64;

/**
 * 最小路径和
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 */
public class Solution {
    private int minRoute;
    private int m, n;

    public int minPathSum(int[][] grid) {
        this.minRoute = Integer.MAX_VALUE;
        this.m = grid.length;
        this.n = m > 0 ? grid[0].length : 0;
        dfs(0, 0, 0, grid);
        return minRoute;
    }

    /**
     * dfs+剪枝 会超时
     */
    private void dfs(int i, int j, int sum, int[][] grid) {
        int theSum = sum + grid[i][j];
        if (i == m - 1 && j == n - 1) {
            if (theSum < minRoute) {
                this.minRoute = theSum;
            }
        } else if (theSum < minRoute) {
            if (i + 1 < m) {
                dfs(i + 1, j, theSum, grid);
            }
            if (j + 1 < n) {
                dfs(i, j + 1, theSum, grid);
            }
        }
    }

    /**
     * 简单二维DP
     */
    public int minPathSum2(int[][] grid) {
        this.m = grid.length;
        this.n = m > 0 ? grid[0].length : 0;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
