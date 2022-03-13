package com.leetcode.main.q154;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 * @see com.leetcode.offer.q11.Solution
 */
public class Solution {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, i;
        while (start < end) {
            i = start + (end - start) / 2;
            if (nums[i] > nums[end]) {
                start = i + 1;
            } else if (nums[i] < nums[end]) {
                end = i;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
