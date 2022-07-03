package com.leetcode.main.interval101.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triList = new ArrayList<>(numRows);
        List<Integer> lastList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    list.add(lastList.get(j - 1) + lastList.get(j));
                }
            }
            triList.add(list);
            lastList = list;
        }
        return triList;
    }
}
