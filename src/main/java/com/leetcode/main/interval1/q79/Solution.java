package com.leetcode.main.interval1.q79;

/**
 * 单词搜索
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-30
 */
public class Solution {
    private int m, n;
    private boolean[][] visited;
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        this.m = board.length;
        this.n = m > 0 ? board[0].length : 0;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯 visited
     */
    private boolean find(char[][] board, int i, int j, String word, int c) {
        if (word.charAt(c) == board[i][j]) {
            visited[i][j] = true;
            if (c == word.length() - 1) return true;
            for (int[] dir : DIRS) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (valid(ni, nj) && !visited[ni][nj] && find(board, ni, nj, word, c + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'a'}}, "a"));
    }
}
