package com.leetcode.main.interval301.q384;

import java.util.Random;

/**
 * 打乱数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public class Solution {
    private final int[] nums;
    private final int[] origin;

    public Solution(int[] nums) {
        this.nums = nums;
        this.origin = new int[nums.length];
        System.arraycopy(nums, 0, origin, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(origin, 0, nums, 0, nums.length);
        return nums;
    }

    /**
     * Fisher-Yates 洗牌算法
     * 数组分为两部分[0, i - 1]是已经乱序的部分, [i, n - 1]等待乱序的部分
     * 从后方随机选取一个元素与i交换
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
