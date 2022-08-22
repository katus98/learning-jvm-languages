package com.leetcode.main.interval801.q896;

/**
 * 单调数列
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-22
 */
public class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) return true;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == -1) {
                    return false;
                }
                flag = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (flag == 1) {
                    return false;
                }
                flag = -1;
            }
        }
        return true;
    }
}
