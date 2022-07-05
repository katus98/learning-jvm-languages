package com.leetcode.main.interval1301.q1314;

import java.util.Arrays;

/**
 * 矩阵区域和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-05
 * @see com.leetcode.main.interval301.q304.NumMatrix
 */
public class Solution {
    private int m, n;

    /**
     * 二维前缀和
     * DP 表示以当前元素为右下角, 矩阵左上角为左上角的矩形的和
     * answer = DP右下角 - DP右上角 - DP左下角 + DP左上角
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        m = mat.length;
        n = m > 0 ? mat[0].length : 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = value(dp, i - 1, j) + value(dp, i, j - 1) - value(dp, i - 1, j - 1) + mat[i][j];
            }
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            int minI = i - k - 1;
            int maxI = Math.min(i + k, m - 1);
            for (int j = 0; j < n; j++) {
                int minJ = j - k - 1;
                int maxJ = Math.min(j + k, n - 1);
                answer[i][j] = dp[maxI][maxJ] - value(dp, minI, maxJ) - value(dp, maxI, minJ) + value(dp, minI, minJ);
            }
        }
        return answer;
    }

    private int value(int[][] mat, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n ? mat[i][j] : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));
    }
}
