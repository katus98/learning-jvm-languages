package com.leetcode.main.interval1701.q1779;

/**
 * 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-19
 */
public class Solution {
    /**
     * 循环遍历
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0], py = points[i][1];
            if (px == x || py == y) {
                int distance = Math.abs(x - px) + Math.abs(y - py);
                if (minDis > distance) {
                    minDis = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}
