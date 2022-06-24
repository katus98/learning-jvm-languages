package com.leetcode.main.interval101.q198;

/**
 * 打家劫舍
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-31
 */
public class Solution {
    /**
     * 原创DP
     * DP表示偷当前i家的最大金钱数
     * 返回必偷最后两家中的最大值
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len > 1) dp[1] = nums[1];
        if (len > 2) dp[2] = dp[0] + nums[2];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 3] + nums[i], dp[i - 2] + nums[i]);
        }
        return len > 1 ? Math.max(dp[len - 1], dp[len - 2]) : dp[len - 1];
    }

    /**
     * d1DP
     * dp表示偷到前i家最大金钱数
     * dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len > 1) dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
