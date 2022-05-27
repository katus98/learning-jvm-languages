package com.leetcode.main.interval1.q78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-06
 */
public class Solution {
    private final List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        list.clear();
        for (int i = 0; i <= nums.length; i++) {
            generateSubsets(nums, 0, i, new ArrayList<>());
        }
        return list;
    }

    /**
     * 生成大小为count的子集
     *
     * @param nums  原始集合
     * @param start 允许开始选取元素的位置
     * @param count 后续生成大小
     * @param set   当前生成的集合
     */
    private void generateSubsets(int[] nums, int start, int count, List<Integer> set) {
        if (count == 0) {
            // 如果已经用完了次数则加入结果集
            list.add(new ArrayList<>(set));
            return;
        }
        // 从允许开始添加的元素开始, 一直到剩下的元素够完成当前大小的子集为止
        for (int i = start; i < nums.length - count + 1; i++) {
            // 添加这个位置的元素
            set.add(nums[i]);
            // 补充后续元素
            generateSubsets(nums, i + 1, count - 1, set);
            // 移除当前位置的元素进入下一个位置
            set.remove(set.size() - 1);
        }
    }
}
