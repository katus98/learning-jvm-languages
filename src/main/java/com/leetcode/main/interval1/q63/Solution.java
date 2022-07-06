package com.leetcode.main.interval1.q63;

/**
 * 不同路径 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-06
 */
public class Solution {
    /**
     * DP 到达当前位置的路径总和 (上方+左方)
     * d2DP: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] (当前位置不是障碍物)
     * d2DP: dp[i][j] = 0 (当前位置是障碍物)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = m > 0 ? obstacleGrid[0].length : 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
