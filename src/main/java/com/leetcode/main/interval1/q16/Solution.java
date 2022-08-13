package com.leetcode.main.interval1.q16;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Solution {
    /**
     * 排序 + 双指针
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) continue;
            int a = nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = a + nums[i] + nums[j];
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return target;
                }
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
