package com.leetcode.main.interval201.q209;

/**
 * 长度最小的子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    /**
     * 双指针
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 1;
        int sum = nums[0], count = Integer.MAX_VALUE;
        while (j <= nums.length) {
            if (sum >= target) {
                if (j - i < count) {
                    count = j - i;
                }
                sum -= nums[i];
                i++;
            } else {
                if (j < nums.length) {
                    sum += nums[j];
                }
                j++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
