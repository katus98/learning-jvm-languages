package com.leetcode.main.interval101.q200;

/**
 * 岛屿数量
 * 扫描整个二维数组, 每次扫描到陆地就进行dfs/bfs
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-16
 */
public class Solution {
    private int l1, l2;
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        this.l1 = grid.length;
        this.l2 = l1 == 0 ? 0 : grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            char[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (line[j] == '1') {
                    sink(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (isValid(ni, nj) && grid[ni][nj] == '1') {
                sink(grid, ni, nj);
            }
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < l1 && j < l2;
    }
}
