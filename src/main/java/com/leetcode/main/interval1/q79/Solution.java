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

    public boolean exist(char[][] board, String word) {
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

    private boolean find(char[][] board, int i, int j, String word, int c) {
        char ch = word.charAt(c);
        if (ch != board[i][j]) return false;
        else if (c >= word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if (valid(i - 1, j) && !visited[i - 1][j] && find(board, i - 1, j, word, c + 1)) {
            return true;
        } else if (valid(i + 1, j) && !visited[i + 1][j] && find(board, i + 1, j, word, c + 1)) {
            return true;
        } else if (valid(i, j - 1) && !visited[i][j - 1] && find(board, i, j - 1, word, c + 1)) {
            return true;
        } else if (valid(i, j + 1) && !visited[i][j + 1] && find(board, i, j + 1, word, c + 1)) {
            return true;
        }
        visited[i][j] = false;
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
