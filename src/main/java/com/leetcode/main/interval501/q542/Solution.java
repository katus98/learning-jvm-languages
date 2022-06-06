package com.leetcode.main.interval501.q542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 矩阵
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-06
 */
public class Solution {
    private int m, n;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 多源BFS, 队列维护当前所有的位置
     */
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = m > 0 ? mat[0].length : 0;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cors = queue.remove();
            int i = cors[0];
            int j = cors[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + DIRS[k][0];
                int nj = j + DIRS[k][1];
                if (valid(ni, nj) && res[ni][nj] > 1 + res[i][j]) {
                    res[ni][nj] = 1 + res[i][j];
                    queue.add(new int[]{ni, nj});
                }
            }
        }
        return res;
    }

    private boolean valid(int... cors) {
        return cors[0] >= 0 && cors[0] < m && cors[1] >= 0 && cors[1] < n;
    }
}
