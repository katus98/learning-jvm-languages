package com.leetcode.main.interval701.q704;

/**
 * 二分查找
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    /**
     * 最基本的二分查找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        // 记录搜索范围上下界, 包含上下界本身
        int start = 0, end = nums.length - 1;
        int cur;
        while (start < end) {
            // 二分
            cur = start + ((end - start) >> 1);
            if (nums[cur] > target) {
                // 右侧界限可以直接落到中间值位置
                end = cur;
            } else if (nums[cur] < target) {
                // 左侧界限必须落到中间值右侧, 否则当start == end - 1时候会进入死循环
                start = cur + 1;
            } else {
                // 强制跳出循环
                start = cur;
                end = cur;
            }
        }
        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
    }
}
