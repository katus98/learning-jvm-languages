package com.leetcode.main.interval501.q566;

/**
 * 重塑矩阵
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-06
 */
public class Solution {
    /**
     * 将二维矩阵映射为一维表示
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = m > 0 ? mat[0].length : 0;
        if (m * n != r * c) return mat;
        int[][] res = new int[r][c];
        int size = m * n;
        for (int i = 0; i < size; i++) {
            int num = getNum(mat, m, n, i);
            setNum(res, r, c, i, num);
        }
        return res;
    }

    private int getNum(int[][] mat, int m, int n, int index) {
        int i = index / n;
        int j = index % n;
        return mat[i][j];
    }

    private void setNum(int[][] mat, int m, int n, int index, int val) {
        int i = index / n;
        int j = index % n;
        mat[i][j] = val;
    }
}
