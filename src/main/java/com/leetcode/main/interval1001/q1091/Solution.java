package com.leetcode.main.interval1001.q1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-18
 */
public class Solution {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    private int n = 0;

    /**
     * BFS
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        // 起始点也需要判断是否可行
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0, 1});
            visited[0][0] = true;
            // 如果只有一个0
            if (n == 1) return 1;
        }
        while (!queue.isEmpty()) {
            int[] cors = queue.remove();
            int i = cors[0];
            int j = cors[1];
            int step = cors[2];
            for (int[] dir : DIRS) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (valid(ni, nj) && !visited[ni][nj] && grid[ni][nj] == 0) {
                    queue.add(new int[]{ni, nj, step + 1});
                    visited[ni][nj] = true;
                    if (ni == nj && ni == n - 1) {
                        return step + 1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
