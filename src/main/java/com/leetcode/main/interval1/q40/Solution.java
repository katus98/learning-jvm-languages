package com.leetcode.main.interval1.q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-05
 */
public class Solution {
    private final List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.resultList.clear();
        combine(candidates, target, new ArrayList<>(), 0);
        return resultList;
    }

    private void combine(int[] candidates, int left, List<Integer> list, int index) {
        if (left < 0) return;
        if (left == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 去重核心
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            combine(candidates, left - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
