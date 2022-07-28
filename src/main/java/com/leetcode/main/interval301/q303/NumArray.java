package com.leetcode.main.interval301.q303;

/**
 * 区域和检索 - 数组不可变
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-28
 */
public class NumArray {
    /**
     * 前缀和
     */
    private final int[] prefix;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length];
        if (prefix.length > 0) {
            prefix[0] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
    }
}
