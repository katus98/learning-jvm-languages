package com.leetcode.main.interval1.q11;

/**
 * 盛最多水的容器
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-28
 */
public class Solution {
    /**
     * 双指针
     * 分别只想数组首尾, 每次计算容量, 将更大的容量单独保存
     * 每次移动两个指针高度较小的那个向内移动一步
     */
    public int maxArea(int[] height) {
        int maxSize = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int size = Math.min(height[i], height[j]) * (j - i);
            if (size > maxSize) {
                maxSize = size;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxSize;
    }
}
