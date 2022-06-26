package com.leetcode.main.interval1.q34;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 * @see com.leetcode.offer.q53.Solution
 */
public class Solution {
    /**
     * 二分法查找之后前后遍历
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int start = 0, end = nums.length - 1, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (nums[cur] < target) {
                start = cur + 1;
            } else if (nums[cur] > target) {
                end = cur;
            } else {
                start = cur;
                end = cur;
            }
        }
        cur = start;
        if (nums[cur] == target) {
            int k = cur;
            while (k < nums.length && nums[k] == target) k++;
            end = k - 1;
            k = cur - 1;
            while (k >= 0 && nums[k] == target) k--;
            start = k + 1;
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }
}
