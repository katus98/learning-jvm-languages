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
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int cur = start + ((end - start) >> 1);
        int res1, res2;
        if (nums[cur] > nums[end]) {
            res1 = searchB(nums, start, cur, target);
            // 此处可以额外判断是否调用
            // 而且需要注意必须是cur + 1
            res2 = search(nums, cur + 1, end, target);
        } else {
            // 此处可以额外判断是否调用
            res1 = search(nums, start, cur, target);
            res2 = searchB(nums, cur + 1, end, target);
        }
        return Math.max(res1, res2);
    }

    private int searchB(int[] nums, int start, int end, int target) {
        int cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (nums[cur] > target) {
                end = cur;
            } else if (nums[cur] < target) {
                start = cur + 1;
            } else {
                start = cur;
                end = cur;
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
