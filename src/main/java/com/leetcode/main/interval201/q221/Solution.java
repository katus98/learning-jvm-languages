package com.leetcode.main.interval201.q221;

/**
 * 最大正方形
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-25
 */
public class Solution {
    private int m, n;

    /**
     * 暴力方法
     */
    public int maximalSquare(char[][] matrix) {
        this.m = matrix.length;
        this.n = m > 0 ? matrix[0].length : 0;
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int size = 1;
                    while (true) {
                        boolean flag = false;
                        for (int k = 0; k < size + 1; k++) {
                            if (isNotValid(i + size, j + k) || matrix[i + size][j + k] == '0') {
                                flag = true;
                                break;
                            }
                            if (isNotValid(i + k, j + size) || matrix[i + k][j + size] == '0') {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                        size++;
                    }
                    if (size > maxSize) maxSize = size;
                }
            }
        }
        return maxSize * maxSize;
    }

    /**
     * 二维dp
     * dp值表示以当前方块为右下角的最大正方形边长
     * 如果当前方块为0, dp=0
     * 如果当前方块为1, dp是其左边上面和左上边dp值最小值+1
     */
    public int maximalSquare2(char[][] matrix) {
        this.m = matrix.length;
        this.n = m > 0 ? matrix[0].length : 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > maxSize) maxSize = dp[i][j];
            }
        }
        return maxSize * maxSize;
    }

    private boolean isNotValid(int i, int j) {
        return i < 0 || j < 0 || i >= m || j >= n;
    }
}
