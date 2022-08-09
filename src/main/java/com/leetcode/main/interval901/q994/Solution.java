package com.leetcode.main.interval901.q994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-06
 */
public class Solution {
    private int m, n;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 多源BFS
     */
    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n = m > 0 ? grid[0].length : 0;
        // 判断一些是否存在好的橘子, 如果不存在就不需要后续处理, 直接返回0
        boolean needProcess = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    needProcess = true;
                }
            }
        }
        if (!needProcess) return 0;
        // 初始值是-1
        int count = -1;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] cors = queue.remove();
                int i = cors[0];
                int j = cors[1];
                for (int d = 0; d < 4; d++) {
                    int ni = i + DIRS[d][0];
                    int nj = j + DIRS[d][1];
                    if (valid(ni, nj) && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        queue.add(new int[]{ni, nj});
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return count;
    }

    private boolean valid(int... cors) {
        return cors[0] >= 0 && cors[0] < m && cors[1] >= 0 && cors[1] < n;
    }
}
