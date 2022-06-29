package com.leetcode.main.interval1301.q1351;

/**
 * 统计有序矩阵中的负数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-29
 */
public class Solution {
    /**
     * 从上到小逆序扫描, 横向指针继承
     */
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int j = n - 1, count = 0;
        for (int[] ints : grid) {
            while (j >= 0 && ints[j] < 0) j--;
            count += n - 1 - j;
        }
        return count;
    }
}
