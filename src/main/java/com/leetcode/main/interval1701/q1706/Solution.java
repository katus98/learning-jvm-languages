package com.leetcode.main.interval1701.q1706;

/**
 * 球会落何处
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-31
 */
public class Solution {
    private int m, n;

    /**
     * 模拟
     */
    public int[] findBall(int[][] grid) {
        this.m = grid.length;
        this.n = m == 0 ? 0 : grid[0].length;
        int[] answer = new int[n];
        for (int j = 0; j < n; j++) {
            int nj = j;
            for (int i = 0; i < m; i++) {
                if (grid[i][nj] == 1) {
                    // 如果当前位置是右挡板
                    if (valid(i, nj + 1) && grid[i][nj + 1] == 1) {
                        // 只有当右侧也是右挡板才能进入下一层
                        nj++;
                    } else {
                        nj = -1;
                        break;
                    }
                } else {
                    // 如果当前位置是左挡板
                    if (valid(i, nj - 1) && grid[i][nj - 1] == -1) {
                        // 只有当左侧也是左挡板才能进入下一层
                        nj--;
                    } else {
                        nj = -1;
                        break;
                    }
                }
            }
            answer[j] = nj;
        }
        return answer;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
