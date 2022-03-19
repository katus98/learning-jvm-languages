package com.leetcode.offer.q53;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 */
public class Solution2 {

    public int missingNumber(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                break;
            }
        }
        return i;
    }

    /**
     * 二分法
     */
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1, c = i + (j - i) / 2;
        while (i < j) {
            if (nums[c] == c) {
                i = c + 1;
            } else {
                j = c;
            }
            c = i + (j - i) / 2;
        }
        if (c == nums[c]) c++;
        return c;
    }
}
