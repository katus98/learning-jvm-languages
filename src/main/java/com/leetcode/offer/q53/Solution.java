package com.leetcode.offer.q53;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 */
public class Solution {
    /**
     * 二分法查找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int i = 0, j = nums.length - 1, c = i + (j - i) / 2;
        while (i < j) {
            if (target < nums[c]) {
                j = c - 1;
            } else if (target > nums[c]) {
                i = c + 1;
            } else {
                i = c;
                j = c;
            }
            c = i + (j - i) / 2;
        }
        if (nums[c] == target) {
            int count = 0;
            for (int k = c; k < nums.length; k++) {
                if (nums[k] == target) count++;
                else break;
            }
            for (int k = c - 1; k >= 0; k--) {
                if (nums[k] == target) count++;
                else break;
            }
            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{1, 4}, 4));
    }
}
