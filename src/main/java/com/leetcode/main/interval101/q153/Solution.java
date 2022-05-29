package com.leetcode.main.interval101.q153;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    /**
     * 通过比较中间值和右侧界限值的大小进行二分
     */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        if (j - i == 1) return Math.min(nums[i], nums[j]);
        int c = i + (j - i) / 2;
        if (nums[j] > nums[c]) {
            return findMin(nums, i, c);
        } else {
            return findMin(nums, c, j);
        }
    }
}
