package com.leetcode.main.interval1.q74;

/**
 * 搜索二维矩阵
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-31
 */
public class Solution {
    private int[][] matrix;
    private int m, n;

    /**
     * 将二维矩阵映射到一维数组然后二分
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = m > 0 ? matrix[0].length : 0;
        int i = 0, j = m * n - 1, c = i;
        while (i < j) {
            c = i + (j - i) / 2;
            if (array(c) > target) {
                j = c;
            } else if (array(c) < target) {
                i = c + 1;
            } else {
                i = c;
                j = c;
            }
        }
        return array(i) == target;
    }

    private int array(int i) {
        int x = i / n;
        int y = i % n;
        return matrix[x][y];
    }
}
