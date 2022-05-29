package com.leetcode.main.interval201.q240;

/**
 * 搜索二维矩阵 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    /**
     * 从右上角或者左下角开始查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int i = 0, j = n - 1;
        boolean result = false;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                result = true;
                break;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
