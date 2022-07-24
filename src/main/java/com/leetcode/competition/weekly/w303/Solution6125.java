package com.leetcode.competition.weekly.w303;

/**
 * 相等行列对
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution6125 {
    public int equalPairs(int[][] grid) {
        int count = 0, n = grid.length;
        int[][] prefix = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][0] += grid[i][j];
                prefix[i][1] += grid[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (prefix[i][0] == prefix[j][1]) {
                    boolean flag = true;
                    for (int k = 0; k < n; k++) {
                        if (grid[i][k] != grid[k][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution6125 solution6125 = new Solution6125();
        System.out.println(solution6125.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(solution6125.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }
}
