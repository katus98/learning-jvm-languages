package com.leetcode.main.interval401.q435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-03
 */
public class Solution {
    /**
     * DP 超时
     * 逆向思维 寻找不重叠的区间序列最大个数
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int maxSize = 1;
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            int[] itv = intervals[i];
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] > j + 1) break;
                int[] itv2 = intervals[j];
                if (itv2[1] <= itv[0] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxSize = Math.max(maxSize, dp[i]);
        }
        return intervals.length - maxSize;
    }

    /**
     * 贪心
     * 逆向思维 寻找不重叠的区间序列最大个数
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
