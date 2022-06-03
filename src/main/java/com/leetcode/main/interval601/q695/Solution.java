package com.leetcode.main.interval601.q695;

/**
 * 岛屿的最大面积
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-03
 */
public class Solution {
    private int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = m > 0 ? grid[0].length : 0;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    if (count > maxArea) {
                        maxArea = count;
                    }
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        int count = 1;
        grid[i][j] = 0;
        if (valid(i - 1, j) && grid[i - 1][j] == 1) {
            count += dfs(grid, i - 1, j);
        }
        if (valid(i + 1, j) && grid[i + 1][j] == 1) {
            count += dfs(grid, i + 1, j);
        }
        if (valid(i, j - 1) && grid[i][j - 1] == 1) {
            count += dfs(grid, i, j - 1);
        }
        if (valid(i, j + 1) && grid[i][j + 1] == 1) {
            count += dfs(grid, i, j + 1);
        }
        return count;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
