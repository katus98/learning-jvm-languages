package com.leetcode.main.q169;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 * @see com.leetcode.offer.q39.Solution
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
