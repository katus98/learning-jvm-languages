package com.leetcode.main.q54;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 没有特别的解法, 耐心写完最外层的遍历然后递归即可
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-12
 * @see com.leetcode.offer.q29.Solution
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();
    private int size = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        this.size = m * n;
        make(matrix, 0, 0, m - 1, 0, n - 1);
        return list;
    }

    private void make(int[][] matrix, int i, int m1, int m2, int n1, int n2) {
        if (m1 <= m2 && n1 <= n2) {
            // 最上面从左到右遍历
            for (int j = n1; j <= n2; j++) {
                i++;
                list.add(matrix[m1][j]);
            }
            // 最右侧从上到下遍历
            for (int j = m1 + 1; j <= m2; j++) {
                i++;
                list.add(matrix[j][n2]);
            }
            // 最内层可能出现只有一行的情况, 跳出递归
            if (i == size) {
                return;
            }
            // 最下层从右到左遍历
            for (int j = n2 - 1; j >= n1; j--) {
                i++;
                list.add(matrix[m2][j]);
            }
            // 最内层可能出现只有一列的情况, 跳出递归
            if (i == size) {
                return;
            }
            // 最左侧从下到上遍历
            for (int j = m2 - 1; j >= m1 + 1; j--) {
                i++;
                list.add(matrix[j][n1]);
            }
            // 进入下一层递归
            make(matrix, i, m1 + 1, m2 - 1, n1 + 1, n2 - 1);
        }
    }
}
