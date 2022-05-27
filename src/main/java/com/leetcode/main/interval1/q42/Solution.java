package com.leetcode.main.interval1.q42;

/**
 * 接雨水
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-15
 */
public class Solution {
    /**
     * 动态规划
     * i位置的水高度取决于i向左向右的最大高度中的最小值减去i位置的高度
     * i位置向左向右的最大高度可以通过动态规划计算
     * maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
     * maxRight[i] = Math.max(maxRight[i + 1], height[i]);
     */
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) return 0;
        int[] maxLeft = new int[length], maxRight = new int[length];
        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        maxRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }
}
