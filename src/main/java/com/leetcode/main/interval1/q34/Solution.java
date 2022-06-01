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
        int i = 0, j = nums.length - 1, c = i + (j - i) / 2;
        while (i < j) {
            if (target < nums[c]) {
                j = c - 1;
            } else if (target > nums[c]) {
                i = c + 1;
            } else {
                i = c;
                j = c;
            }
            c = i + (j - i) / 2;
        }
        if (nums[c] == target) {
            int count = 0;
            int k;
            for (k = c; k < nums.length; k++) {
                if (nums[k] != target) break;
            }
            j = k - 1;
            for (k = c - 1; k >= 0; k--) {
                if (nums[k] != target) break;
            }
            i = k + 1;
            return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }
}
