package com.leetcode.main.interval101.q152;

/**
 * 乘积最大子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-30
 */
public class Solution {
    /**
     * DP: 以i结尾的乘积最大值等于前一位的最大值*当前位置, 当前位置, 前一位最小值*当前位置 三者最大值
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(nums[i], minF[i - 1] * nums[i]));
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
