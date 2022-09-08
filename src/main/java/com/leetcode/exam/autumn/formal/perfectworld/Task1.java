package com.leetcode.exam.autumn.formal.perfectworld;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-08
 */
public class Task1 {
    public int maximumTotal(int[][] triangle) {
        int res = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
                if (i == triangle.length - 1) {
                    res = Math.max(res, triangle[i][j]);
                }
            }
        }
        return res;
    }
}
