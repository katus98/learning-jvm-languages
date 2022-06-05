package com.leetcode.main.interval1.q26;

/**
 * 删除有序数组中的重复项
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-05
 */
public class Solution {
    /**
     * 常规
     */
    public int removeDuplicates(int[] nums) {
        int realLast = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[realLast] != nums[i]) {
                move(nums, i, realLast + 1);
                realLast++;
            }
        }
        return realLast + 1;
    }

    private void move(int[] nums, int ori, int dest) {
        if (ori != dest) {
            nums[dest] = nums[ori];
        }
    }
}
