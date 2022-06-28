package com.leetcode.main.interval1601.q1608;

import java.util.Arrays;

/**
 * 特殊数组的特征值
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-28
 */
public class Solution {
    /**
     * 原创二分 (我就是神)
     * 倒序排列数组, 数组下标+1即为x是递增的, 数组值是递减的
     * 通过二分法找到两者大小关系的交界处 (这个地方是唯一可能的特征值)
     * 然后检验一下这个特征值是否有效即可
     */
    public int specialArray(int[] nums) {
        // 倒序排序
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        // 二分法
        int start = 0, end = nums.length - 1, cur;
        while (start < end) {
            cur = start + ((end - start + 1) >> 1);
            // 下标+1就是可能的特征值
            int x = cur + 1;
            // 判断特征值大小与数组值的关系
            if (x <= nums[cur]) {
                start = cur;
            } else {
                end = cur - 1;
            }
        }
        // 出口start + 1表示唯一可能的特征值
        if (start + 1 == nums.length) {
            // 特征值和数组等长, 本项>=x即可
            return start + 1 <= nums[start] ? start + 1 : -1;
        } else {
            // 如果特征值小于数组长度, 要求本项>=x, 下一项<x
            return start + 1 <= nums[start] && start + 1 > nums[start + 1] ? start + 1 : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.specialArray(new int[]{3, 6, 7, 7, 0}));
    }
}
