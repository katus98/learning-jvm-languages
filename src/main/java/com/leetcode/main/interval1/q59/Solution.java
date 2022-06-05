package com.leetcode.main.interval1.q59;

/**
 * 螺旋矩阵 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-05
 */
public class Solution {
    /**
     * 模拟
     */
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int num = 1, i = 0, j = 0;
        while (num <= n * n) {
            while (j < n && array[i][j] == 0) {
                array[i][j++] = num++;
            }
            j--;
            i++;
            while (i < n && array[i][j] == 0) {
                array[i++][j] = num++;
            }
            i--;
            j--;
            while (j >= 0 && array[i][j] == 0) {
                array[i][j--] = num++;
            }
            j++;
            i--;
            while (i >= 0 && array[i][j] == 0) {
                array[i--][j] = num++;
            }
            i++;
            j++;
        }
        return array;
    }
}
