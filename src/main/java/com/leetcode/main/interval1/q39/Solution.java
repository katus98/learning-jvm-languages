package com.leetcode.main.interval1.q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 */
public class Solution {
    private final List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.resList.clear();
        for (int i = 1; i <= target; i++) {
            combine(candidates, target, 0, i, 0, new ArrayList<>());
        }
        return resList;
    }

    private void combine(int[] candidates, int target, int index, int count, int sum, List<Integer> list) {
        if (count == 0) {
            if (target == sum) {
                resList.add(new ArrayList<>(list));
            }
            return;
        }
        if (sum + candidates[index] * count <= target) {   // 剪枝
            for (int i = index; i < candidates.length; i++) {
                // 回溯
                list.add(candidates[i]);
                combine(candidates, target, i, count - 1, sum + candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 简化上面方法中不需要的部分, 例如排序和限制长度
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.resList.clear();
        combine(candidates, target, 0, new ArrayList<>());
        return resList;
    }

    private void combine(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                combine(candidates, target - candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
