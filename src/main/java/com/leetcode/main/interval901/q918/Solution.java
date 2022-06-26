package com.leetcode.main.interval901.q918;

/**
 * 环形子数组的最大和
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-26
 * @see com.leetcode.main.interval1.q53.Solution
 */
public class Solution {
    /**
     * 环形子数组的最大和 = Math.max(最大子数组和, 总和 - [1, n-2]最小子数组和)
     */
    public int maxSubarraySumCircular(int[] nums) {
        int pre = nums[0], maxSum = nums[0], sum = nums[0], minSum = 0;
        // 最大子数组和
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            if (maxSum < pre) {
                maxSum = pre;
            }
            sum += nums[i];
        }
        pre = 0;
        // [1, n - 2]最小子数组和
        for (int i = 1; i < nums.length - 1; i++) {
            pre = Math.min(nums[i], pre + nums[i]);
            if (minSum > pre) {
                minSum = pre;
            }
        }
        return Math.max(maxSum, sum - minSum);
    }
}
