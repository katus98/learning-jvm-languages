package com.leetcode.q704;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int current = (start + end) / 2;
        while (nums[current] != target) {
            if (start == end || start == end - 1) {
                break;
            }
            if (nums[current] > target) {
                end = current;
            } else {
                start = current;
            }
            current = (start + end) / 2;
        }
        if (nums[current] == target) {
            return current;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 12));
    }
}
