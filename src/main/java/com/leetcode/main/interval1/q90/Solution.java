package com.leetcode.main.interval1.q90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-19
 */
public class Solution {
    private final List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.resList.clear();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            combine(nums, 0, i, new ArrayList<>());
        }
        return resList;
    }

    private void combine(int[] nums, int i, int n, List<Integer> list) {
        if (list.size() == n) {
            resList.add(new ArrayList<>(list));
            return;
        }
        if (list.size() + (nums.length - i) < n) return;
        for (int j = i; j < nums.length; j++) {
            // 处理不能重复: 选择下一个位置的元素时, 不能与这个循环的上一次一致
            if (j > i && nums[j] == nums[j - 1]) continue;
            list.add(nums[j]);
            combine(nums, j + 1, n, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsetsWithDup(new int[]{1, 2, 2}).forEach(list -> {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }
}
