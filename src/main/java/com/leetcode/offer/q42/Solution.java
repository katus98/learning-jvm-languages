package com.leetcode.offer.q42;

/**
 * 连续子数组的最大和
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 * @see com.leetcode.main.interval1.q53.Solution
 */
public class Solution {
    /**
     * 动态规划, 假设最大子串的最后一位是i位置, 则可能包含i自己或者自己和前面的和, 判断标准是通过比较大小
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            // 确定当前位置是包含前面的元素更大还是不包含前面的元素更大
            pre = Math.max(num, pre + num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
