package com.leetcode.main.interval201.q268;

import java.util.Arrays;

/**
 * 丢失的数字
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-19
 */
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && nums[i] == i) {
            i++;
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            res ^= i;
        }
        return res;
    }

    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }
}
