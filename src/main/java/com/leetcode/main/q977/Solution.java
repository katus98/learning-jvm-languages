package com.leetcode.main.q977;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-04
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int k = nums.length, i = 0, j = k - 1;
        int[] array = new int[k];
        while (k-- > 0) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                array[k] = nums[i] * nums[i];
                i++;
            } else {
                array[k] = nums[j] * nums[j];
                j--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}
