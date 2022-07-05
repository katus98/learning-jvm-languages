package com.leetcode.main.interval301.q304;

/**
 * 二维区域和检索 - 矩阵不可变
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 * @see com.leetcode.main.interval1301.q1314.Solution
 */
public class NumMatrix {
    private final int m, n;
    private final int[][] dp;

    /**
     * DP 二维左上角前缀和
     */
    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        this.n = m > 0 ? matrix[0].length : 0;
        this.dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = value(dp, i - 1, j) + value(dp, i, j - 1) - value(dp, i - 1, j - 1) + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2] - value(dp, row1 - 1, col2) - value(dp, row2, col1 - 1) + value(dp, row1 - 1, col1 - 1);
    }

    private int value(int[][] mat, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n ? mat[i][j] : 0;
    }
}
