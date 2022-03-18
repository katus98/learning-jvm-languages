package com.leetcode.offer.q47;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    private int m, n;

    /**
     * 需要用有记忆的dp, 用空间换时间
     */
    public int maxValue(int[][] grid) {
        this.m = grid.length;
        this.n = m > 0 ? grid[0].length : 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * DFS会超时
     * dfs(grid, 0, 0, 0);
     */
    private void dfs(int[][] grid, int i, int j, int sum) {
        if (i == m - 1 && j == n - 1) {
            sum += grid[i][j];
            this.maxSum = Math.max(sum, maxSum);
        } else if (i < m && j < n) {
            sum += grid[i][j];
            dfs(grid, i + 1, j, sum);
            dfs(grid, i, j + 1, sum);
        }
    }

    /**
     * 用了dp, 还是超时
     * dp(grid, m - 1, n - 1)
     */
    private int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[i][j];
        int right = 0;
        int down = 0;
        if (i > 0) {
            right = dp(grid, i - 1, j);
        }
        if (j > 0) {
            down = dp(grid, i, j - 1);
        }
        return Math.max(right, down) + grid[i][j];
    }
}
