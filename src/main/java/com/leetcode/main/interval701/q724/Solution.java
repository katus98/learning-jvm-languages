package com.leetcode.main.interval701.q724;

/**
 * 寻找数组的中心下标
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-14
 */
public class Solution {
    /**
     * 前缀和
     */
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length];
        left[0] = nums[0];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) return i;
        }
        return -1;
    }
}
