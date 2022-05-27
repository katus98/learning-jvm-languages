package com.leetcode.main.interval1.q46;

import java.util.*;

/**
 * 全排列
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 */
public class Solution {
    private final List<List<Integer>> list = new ArrayList<>();
    private int n;

    /**
     * 回溯法
     */
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        arrange(0, numList);
        return list;
    }

    /**
     * 递归函数
     *
     * @param i 当前需要处理第几位字符
     * @param l 当前组合
     */
    private void arrange(int i, List<Integer> l) {
        // 如果当前已经到最后一位了, 说明当前是一个有效的排列
        if (i == n) {
            list.add(new ArrayList<>(l));
            return;
        }
        // 逐位交换
        for (int j = i; j < n; j++) {
            // 动态维护数组
            Collections.swap(l, i, j);
            // 继续递归填下一个数
            arrange(i + 1, l);
            // 撤销操作
            Collections.swap(l, i, j);
        }
    }
}
