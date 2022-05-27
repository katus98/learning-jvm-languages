package com.leetcode.main.interval2101.q2104;

/**
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-04
 */
public class Solution {

    public long subArrayRanges(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int valMin = Integer.MAX_VALUE, valMax = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                valMin = Math.min(valMin, nums[j]);
                valMax = Math.max(valMax, nums[j]);
                result += valMax - valMin;
            }
        }
        return result;
    }
}
