package com.leetcode.offer.q4;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-06
 */
public class Solution {

    /**
     * NlogN 遍历+二分
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length, m = n == 0 ? 0 : matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (m > 0 && target > matrix[i][m-1]) {
                continue;
            }
            int start = 0, end = m, j;
            while (start < end) {
                j = start + (end - start) / 2;
                if (target > matrix[i][j]) {
                    start = j + 1;
                } else if (target < matrix[i][j]) {
                    end = j;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从右上角判断, 大则向下, 小则向左
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int n = matrix.length, m = n == 0 ? 0 : matrix[0].length;
        int i = 0, j = m - 1;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[5][];
        matrix[0] = new int[]{1,4,7,11,15};
        matrix[1] = new int[]{2,5,8,12,19};
        matrix[2] = new int[]{3,6,9,16,22};
        matrix[3] = new int[]{10,13,14,17,24};
        matrix[4] = new int[]{18,21,23,26,30};
        System.out.println(solution.findNumberIn2DArray2(matrix, 5));
    }
}
