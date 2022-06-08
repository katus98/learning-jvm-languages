package com.leetcode.main.interval1.q77;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-08
 */
public class Solution {
    private final List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.resultList.clear();
        combine(n, k, 1, new ArrayList<>());
        return resultList;
    }

    private void combine(int n, int k, int i, List<Integer> list) {
        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            combine(n, k, j + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
