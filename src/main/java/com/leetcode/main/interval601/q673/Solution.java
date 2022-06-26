package com.leetcode.main.interval601.q673;

import java.util.Arrays;

/**
 * 最长递增子序列的个数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-26
 * @see com.leetcode.main.interval201.q300.Solution
 */
public class Solution {
    /**
     * DP
     */
    public int findNumberOfLIS(int[] nums) {
        // 以当前元素为结尾的最长子序列长度
        int[] dp = new int[nums.length];
        // 以当前元素为结尾的最长子序列的数量
        int[] count = new int[nums.length];
        // 记录最长子序列长度
        int maxLisSize = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 如果发现可以组成递增序列
                    if (dp[i] < dp[j] + 1) {
                        // 更长需要更新当前长度
                        dp[i] = dp[j] + 1;
                        // 当前子序列长度的序列数量和接过来的元素一致
                        count[i] = count[j];
                        if (maxLisSize < dp[i]) {
                            // 更新最长子序列长度
                            maxLisSize = dp[i];
                        }
                    } else if (dp[i] == dp[j] + 1) {
                        // 如果与当前长度一致
                        // 数量增加
                        count[i] += count[j];
                    }
                }
            }
        }
        int res = 0;
        // 将所有长度等于最长的数量求和
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLisSize) {
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(new int[]{5, 5, 5, 5, 5}));
    }
}
