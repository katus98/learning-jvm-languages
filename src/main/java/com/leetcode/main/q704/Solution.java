package com.leetcode.main.q704;

/**
 * 二分查找
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1, cur;
        while (i < j) {
            cur = i + (j - i) / 2;
            if (nums[cur] > target) {
                j = cur - 1;
            } else if (nums[cur] < target) {
                i = cur + 1;
            } else {
                i = cur;
                j = cur;
            }
        }
        if (nums[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 12));
    }
}
