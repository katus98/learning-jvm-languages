package com.leetcode.main.interval1.q73;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-07
 */
public class Solution {
    /**
     * 记录需要赋值0的行列号
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int row : rowSet) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col : colSet) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
