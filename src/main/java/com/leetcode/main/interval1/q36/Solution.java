package com.leetcode.main.interval1.q36;

/**
 * 有效的数独
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-07
 */
public class Solution {
    /**
     * 统计数量
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] block = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int x = ch - '1';
                    line[i][x]++;
                    col[j][x]++;
                    block[i / 3][j / 3][x]++;
                    if (line[i][x] > 1 || col[j][x] > 1 || block[i / 3][j / 3][x] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
