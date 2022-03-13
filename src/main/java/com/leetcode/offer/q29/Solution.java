package com.leetcode.offer.q29;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-12
 */
public class Solution {
    private int[] array;

    /**
     * 实话说没什么好方法, 耐心写完一层的逻辑然后递归吧
     */
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        this.array = new int[m * n];
        make(matrix, 0, 0, m - 1, 0, n - 1);
        return array;
    }

    private void make(int[][] matrix, int i, int m1, int m2, int n1, int n2) {
        if (m1 <= m2 && n1 <= n2) {
            for (int j = n1; j <= n2; j++) {
                array[i++] = matrix[m1][j];
            }
            for (int j = m1 + 1; j <= m2; j++) {
                array[i++] = matrix[j][n2];
            }
            if (i == array.length) {
                return;
            }
            for (int j = n2 - 1; j >= n1; j--) {
                array[i++] = matrix[m2][j];
            }
            if (i == array.length) {
                return;
            }
            for (int j = m2 - 1; j >= m1 + 1; j--) {
                array[i++] = matrix[j][n1];
            }
            make(matrix, i, m1 + 1, m2 - 1, n1 + 1, n2 - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] order = solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (int i : order) {
            System.out.println(i);
        }
    }
}
