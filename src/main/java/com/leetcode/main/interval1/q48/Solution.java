package com.leetcode.main.interval1.q48;

/**
 * 旋转图像
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 */
public class Solution {
    /**
     * 找规律
     * 遍历左上角四分之一
     * 找寻当前坐标到矩阵中心的距离, 如果偶数无法整除可以整体*2
     * 要注意横纵坐标和横竖方向上的长度是相反的
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int cx = n / 2;
        int cy = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int ci = n - 1;
        int delX, delY, i2, j2, i3, j3, i4, j4, temp;
        for (int i = 0; i < cx; i++) {
            for (int j = 0; j < cy; j++) {
                delX = Math.abs(j * 2 - ci);
                delY = Math.abs(i * 2 - ci);
                i2 = (ci - delX) / 2;
                j2 = (ci + delY) / 2;
                i3 = (ci + delY) / 2;
                j3 = (ci + delX) / 2;
                i4 = (ci + delX) / 2;
                j4 = (ci - delY) / 2;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i4][j4];
                matrix[i4][j4] = matrix[i3][j3];
                matrix[i3][j3] = matrix[i2][j2];
                matrix[i2][j2] = temp;
            }
        }
    }

    /**
     * 先水平翻转 (上下翻转), 然后主对角线翻转
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
