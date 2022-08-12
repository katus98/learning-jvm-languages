package com.leetcode.main.interval401.q416;

/**
 * 分割等和子集
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-20
 */
public class Solution {
    /**
     * DP 表示前i个元素(索引号)选元素是否可以和等于j
     * dp[i][j] = dp[i - 1][j - nums[i]] | dp[i - 1][j] (j >= nums[i])
     * dp[i][j] = dp[i - 1][j] (j < nums[i])
     */
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int maxNum = 0, total = 0;
        for (int num : nums) {
            total += num;
            maxNum = Math.max(maxNum, num);
        }
        if (total % 2 != 0) return false;
        int target = total / 2;
        if (maxNum > target) return false;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    // 如果选取了num[i]则需要考虑前i-1项的情况, 否则会重复选择num[i]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{2, 2, 3, 5}));
    }
}
