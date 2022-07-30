package com.leetcode.main.interval301.q329;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 矩阵中的最长递增路径
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-30
 */
public class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    /**
     * 基于出度的拓扑排序
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] outDegrees = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                for (int[] dir : DIRS) {
                    int newRow = i + dir[0], newColumn = j + dir[1];
                    if (valid(newRow, newColumn) && matrix[newRow][newColumn] > matrix[i][j]) {
                        ++outDegrees[i][j];
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : DIRS) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (valid(newRow, newColumn) && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outDegrees[newRow][newColumn];
                        if (outDegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean valid(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < columns;
    }
}
