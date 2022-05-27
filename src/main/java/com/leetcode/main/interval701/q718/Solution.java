package com.leetcode.main.interval701.q718;

/**
 * 最长重复子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-27
 */
public class Solution {
    /**
     * DP
     * 表示以第i j项开头的最长公共前缀
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int answer = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                answer = Math.max(dp[i][j], answer);
            }
        }
        return answer;
    }
}
