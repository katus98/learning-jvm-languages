package com.leetcode.competition.weekly.w305;

import java.util.UUID;

/**
 * 检查数组是否存在有效划分
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Solution6137 {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    dp[i + 1] |= dp[i - 1];
                }
                if (i > 1) {
                    int delta = nums[i] - nums[i - 1];
                    if (delta == nums[i - 1] - nums[i - 2] && (delta == 0 || delta == 1)) {
                        dp[i + 1] |= dp[i - 2];
                    }
                }
            }
        }
        return dp[nums.length];
    }
}
