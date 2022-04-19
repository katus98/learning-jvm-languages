package com.leetcode.main.q300;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 动态规划: dp[i] = 符合条件的dp中最大的数
 * dp[i] 以num[i]结尾的最长递增子序列数量
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-19
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLisSize = dp.length > 0 ? 1 : 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    maxLisSize = Math.max(maxLisSize, dp[i]);
                }
            }
        }
        return maxLisSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
