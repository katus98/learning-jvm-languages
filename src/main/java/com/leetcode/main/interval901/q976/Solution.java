package com.leetcode.main.interval901.q976;

import java.util.Arrays;

/**
 * 三角形的最大周长
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-19
 */
public class Solution {
    /**
     * 数学推导
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
