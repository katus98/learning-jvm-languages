package com.leetcode.main.interval1501.q1572;

/**
 * 矩阵对角线元素的和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-23
 */
public class Solution {
    /**
     * 循环判断
     */
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (i != n - i - 1) {
                sum += mat[i][n - i - 1];
            }
        }
        return sum;
    }
}
