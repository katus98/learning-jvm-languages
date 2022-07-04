package com.leetcode.main.interval101.q120;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-09
 */
public class Solution {
    /**
     * DP二维 三角形
     * d2DP: dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        if (dp.length > 0) dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[dp.length - 1][i] < result) {
                result = dp[dp.length - 1][i];
            }
        }
        return result;
    }
}
