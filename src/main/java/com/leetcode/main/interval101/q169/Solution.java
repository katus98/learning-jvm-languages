package com.leetcode.main.interval101.q169;

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 * @see com.leetcode.offer.q39.Solution
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     */
    public int majorityElement2(int[] nums) {
        // 设置候选人和票数
        int candidate = 0, count = 0;
        for (int num : nums) {
            // 如果票数为0, 更换候选人
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                // 如果与当前相同票数+1, 否则-1
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
