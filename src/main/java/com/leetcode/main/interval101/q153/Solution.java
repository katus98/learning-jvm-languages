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

    private int findMin(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int cur = start + ((end - start) >> 1);
        if (nums[end] > nums[cur]) {
            return findMin(nums, start, cur);
        } else {
            return findMin(nums, cur + 1, end);
        }
    }
}
