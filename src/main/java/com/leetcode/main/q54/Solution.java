package com.leetcode.main.q54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-12
 * @see com.leetcode.offer.q29.Solution
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();
    private int size = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        this.size = m * n;
        make(matrix, 0, 0, m - 1, 0, n - 1);
        return list;
    }

    private void make(int[][] matrix, int i, int m1, int m2, int n1, int n2) {
        if (m1 <= m2 && n1 <= n2) {
            for (int j = n1; j <= n2; j++) {
                i++;
                list.add(matrix[m1][j]);
            }
            for (int j = m1 + 1; j <= m2; j++) {
                i++;
                list.add(matrix[j][n2]);
            }
            if (i == size) {
                return;
            }
            for (int j = n2 - 1; j >= n1; j--) {
                i++;
                list.add(matrix[m2][j]);
            }
            if (i == size) {
                return;
            }
            for (int j = m2 - 1; j >= m1 + 1; j--) {
                i++;
                list.add(matrix[j][n1]);
            }
            make(matrix, i, m1 + 1, m2 - 1, n1 + 1, n2 - 1);
        }
    }
}
