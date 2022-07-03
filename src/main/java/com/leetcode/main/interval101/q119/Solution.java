package com.leetcode.main.interval101.q119;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(0);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0, 0);
            for (int j = 0; j <= i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        row.remove(row.size() - 1);
        return row;
    }
}
