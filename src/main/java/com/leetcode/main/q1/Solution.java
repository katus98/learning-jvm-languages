package com.leetcode.main.q1;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println(res[0] + ":" + res[1]);
    }
}
