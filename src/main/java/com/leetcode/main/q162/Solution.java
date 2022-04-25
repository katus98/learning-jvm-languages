package com.leetcode.main.q162;

/**
 * 寻找峰值
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-25
 */
public class Solution {
    /**
     * 找到最大值
     */
    public int findPeakElement(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 从左到右找到第一个下降的位置
     */
    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * 二分查找下降的位置
     */
    public int findPeakElement3(int[] nums) {
        int i = 0, j = nums.length - 1, c;
        while (i < j) {
            c = i + (j - i) / 2;
            if (nums[c] < nums[c + 1]) {
                i = c + 1;
            } else {
                j = c;
            }
        }
        return i;
    }
}
