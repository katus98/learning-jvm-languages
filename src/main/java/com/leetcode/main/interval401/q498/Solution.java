package com.leetcode.main.interval401.q498;

/**
 * 对角线遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-31
 */
public class Solution {
    /**
     * 对角线上的角标和是一个固定的值
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = m > 0 ? mat[0].length : 0;
        int[] array = new int[m * n];
        int i, j, c = 0;
        boolean flag = true;
        for (int sum = 0; sum <= m + n - 2; sum++) {
            if (flag) {
                for (i = Math.min(m - 1, sum), j = sum - i; i >= 0 && j < n; i--, j++) {
                    array[c++] = mat[i][j];
                }
                flag = false;
            } else {
                for (j = Math.min(n - 1, sum), i = sum - j; j >= 0 && i < m; j--, i++) {
                    array[c++] = mat[i][j];
                }
                flag = true;
            }
        }
        return array;
    }
}
