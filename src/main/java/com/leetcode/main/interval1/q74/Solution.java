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
        int start = 0, end = m * n - 1, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (array(cur) > target) {
                end = cur;
            } else if (array(cur) < target) {
                start = cur + 1;
            } else {
                start = cur;
                end = cur;
            }
        }
        return array(start) == target;
    }

    private int array(int i) {
        int x = i / n;
        int y = i % n;
        return matrix[x][y];
    }
}
