package com.leetcode.main.interval1001.q1035;

/**
 * 不相交的线
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-05
 * @see com.leetcode.main.interval1101.q1143.Solution
 */
public class Solution {
    /**
     * 做法等同于最长公共子序列
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j < n2 + 1; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
