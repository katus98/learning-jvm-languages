package com.leetcode.main.interval101.q130;

/**
 * 被围绕的区域
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-18
 */
public class Solution {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    /**
     * DFS
     */
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = m > 0 ? board[0].length : 0;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, 'O', '5');
            dfs(board, i, n - 1, 'O', '5');
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, 'O', '5');
            dfs(board, m - 1, j, 'O', '5');
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '5') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, char oCh, char nCh) {
        if (board[i][j] == oCh) {
            board[i][j] = nCh;
            for (int[] dir : DIRS) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (valid(ni, nj)) {
                    dfs(board, ni, nj, oCh, nCh);
                }
            }
        }
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
