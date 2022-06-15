package com.leetcode.main.interval701.q713;

/**
 * 乘积小于 K 的子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-15
 */
public class Solution {
    /**
     * 双指针/滑动窗口
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) return 0;
        int l = 0;
        int prod = 1; // 存储nums[l]~nums[r]的累积
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            // 获得一个符合条件的乘积
            while (prod >= k) {
                prod /= nums[l++];
            }
            // 只统计包含r的子数组防止重复
            res += r - l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
