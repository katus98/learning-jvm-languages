package com.leetcode.main.interval1.q33;

/**
 * 搜索旋转排序数组
 * 二分查找, 每次二分可以分成一个递增序列和一个不完全递增序列, 不完全的继续递归
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-04
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int c = start + (end - start) / 2, res1, res2;
        if (nums[c] > nums[end]) {
            if (target < nums[start] || target > nums[c]) {
                res1 = -1;
            } else {
                res1 = searchB(nums, start, c, target);
            }
            // c + 1 是可行的, c 是不可行的, 会造成死循环
            res2 = search(nums, c + 1, end, target);
        } else {
            res1 = search(nums, start, c, target);
            if (target < nums[c + 1] || target > nums[end]) {
                res2 = -1;
            } else {
                res2 = searchB(nums, c + 1, end, target);
            }
        }
        return res1 == -1 ? res2 : res1;
    }

    private int searchB(int[] nums, int start, int end, int target) {
        int c;
        while (start < end) {
            c = start + (end - start) / 2;
            if (target > nums[c]) {
                start = c + 1;
            } else if (target < nums[c]) {
                end = c - 1;
            } else {
                start = c;
                end = c;
            }
        }
        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{1, 3}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
