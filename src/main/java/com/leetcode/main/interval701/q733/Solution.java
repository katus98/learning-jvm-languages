package com.leetcode.main.interval701.q733;

/**
 * 图像渲染
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-05
 */
public class Solution {
    private int m, n;
    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.m = image.length;
        this.n = m > 0 ? image[0].length : 0;
        // 只有新旧颜色不同才需要涂色
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (image[i][j] == oldColor) {
            image[i][j] = newColor;
            for (int[] dir : DIRS) {
                int x = i + dir[0], y = j + dir[1];
                if (valid(x, y)) {
                    dfs(image, x, y, oldColor, newColor);
                }
            }
        }
    }

    private boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
