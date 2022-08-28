package com.leetcode.main.interval1801.q1886;

/**
 * 判断矩阵经轮转后是否一致
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-28
 */
public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean flag;
        for (int k = 0; k < 4; k++) {
            flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int m;
                    // 旋转坐标变换公式
                    switch (k) {
                        case 0:
                            // 不变 / 旋转360
                            m = mat[i][j];
                            break;
                        case 1:
                            // 顺时针旋转90
                            m = mat[j][n - i - 1];
                            break;
                        case 2:
                            // 旋转180
                            m = mat[n - i - 1][n - j - 1];
                            break;
                        default:
                            // 顺时针旋转270
                            m = mat[n - j - 1][i];
                    }
                    if (m != target[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) return true;
        }
        return false;
    }
}
