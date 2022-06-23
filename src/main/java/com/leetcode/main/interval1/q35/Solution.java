package com.leetcode.main.interval1.q35;

/**
 * 搜索插入位置
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, cur;
        // 这个二分法模板退出迭代的只可能是找到目标值或者没找到start == end == 比target大一点的数的位置两种情况之一
        // 但是要注意: 后一种情况在target大于所有的值的时候例外, 此时start == end == nums.length - 1
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
        // 当结果是最后一个位置时需要判断是当前位置还是插在整个数组的后面
        return start == nums.length - 1 && nums[start] < target ? nums.length : start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 7}, 3));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 7}, 4));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 7}, 6));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 7}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 7}, 8));
    }
}
