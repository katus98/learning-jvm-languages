package com.leetcode.main.interval301.q376;

/**
 * 摆动序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-09
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        int[] dp = new int[nums.length];
        int[] delta = new int[nums.length];
        dp[0] = 1;
        delta[0] = 0;
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == 1) {
                    delta[i] = nums[i] - nums[j];
                    dp[i] = delta[i] == 0 ? 1 : 2;
                    continue;
                }
                if ((nums[i] - nums[j]) * delta[j] < 0) {
                    dp[i] = dp[j] + 1;
                    delta[i] = nums[i] - nums[j];
                    break;
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    /**
     * DP 表示到i为止的前缀中递增/递减结尾的摆动序列长度最大值
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
