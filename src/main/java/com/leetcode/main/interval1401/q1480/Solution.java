package com.leetcode.main.interval1401.q1480;

/**
 * 一维数组的动态和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-14
 */
public class Solution {
    /**
     * 原地修改
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
