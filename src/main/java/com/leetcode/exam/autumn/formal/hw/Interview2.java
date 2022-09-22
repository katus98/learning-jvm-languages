package com.leetcode.exam.autumn.formal.hw;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-20
 */
public class Interview2 {
    public int numIslands(char[][] grid, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sinkDfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void sinkDfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (isValid(ni, nj, m, n) && grid[ni][nj] == '1') {
                sinkDfs(grid, ni, nj, m, n);
            }
        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {
        Interview2 interview2 = new Interview2();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(interview2.numIslands(grid, 4, 5));
    }
}
