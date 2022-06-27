package com.leetcode.main.interval1501.q1567;

/**
 * 乘积为正数的最长子数组长度
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public class Solution {
    /**
     * 乘积类题都需要维护一个正的dp和一个负的dp
     * DP: 表示以当前位置结尾的乘积为正/负数的最长子数组长度
     */
    public int getMaxLen(int[] nums) {
        int[] dpPos = new int[nums.length];
        int[] dpNeg = new int[nums.length];
        if (nums[0] > 0) {
            dpPos[0] = 1;
            dpNeg[0] = 0;
        } else if (nums[0] < 0) {
            dpPos[0] = 0;
            dpNeg[0] = 1;
        }
        int res = dpPos[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dpPos[i] = Math.max(1, dpPos[i - 1] + 1);
                if (dpNeg[i - 1] > 0) {
                    dpNeg[i] = dpNeg[i - 1] + 1;
                }
            } else if (nums[i] < 0) {
                dpNeg[i] = Math.max(1, dpPos[i - 1] + 1);
                if (dpNeg[i - 1] > 0) {
                    dpPos[i] = dpNeg[i - 1] + 1;
                }
            }
            res = Math.max(res, dpPos[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxLen(new int[]{1, -2, -3, 4}));
    }
}
