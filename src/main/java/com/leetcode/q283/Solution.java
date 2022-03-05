package com.leetcode.q283;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-05
 */
public class Solution {

    /**
     * 暴力解法
     */
    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                moveFirst2Last(nums, i, nums.length - 1);
            }
        }
    }

    private void moveFirst2Last(int[] nums, int start, int end) {
        if (end - start >= 0) System.arraycopy(nums, start + 1, nums, start, end - start);
        nums[end] = 0;
    }

    /**
     * 双指针解法: 不是考虑移动0, 而是考虑移动非零的数到左边
     */
    public void moveZeroes2(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[end++] = nums[i];
            }
        }
        for (int i = end; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
