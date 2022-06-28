package com.leetcode.main.interval1001.q1014;

/**
 * 最佳观光组合
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-28
 */
public class Solution {
    /**
     * DP
     * 求 values[i] + i + values[j] - j 的最大值相当于固定values[i] + i最大值同时遍历j即可
     */
    public int maxScoreSightseeingPair(int[] values) {
        // values[i] + i 的最大值
        int mx = values[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            // 更新目标最大值
            res = Math.max(res, mx + values[i] - i);
            // 更新values[i] + i最大值
            mx = Math.max(mx, values[i] + i);
        }
        return res;
    }
}
