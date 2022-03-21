package com.leetcode.offer.q57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 */
public class Solution2 {
    private final List<int[]> list = new ArrayList<>();
    /**
     * 暴力解法
     */
    public int[][] findContinuousSequence(int target) {
        for (int i = 1; i < target - 1; i++) {
            for (int j = i + 1; j < target; j++) {
                int num = compareTo(i, j, target);
                if (num > 0) break;
                if (num == 0) {
                    int[] res = new int[j - i + 1];
                    for (int k = 0; k < res.length; k++) {
                        res[k] = k + i;
                    }
                    list.add(res);
                }
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    /**
     * 双指针解法
     */
    public int[][] findContinuousSequence2(int target) {
        int i = 1, j = 2;
        while (i < j) {
            int num = compareTo(i, j, target);
            if (num > 0) {
                i++;
            } else if (num < 0) {
                j++;
            } else {
                int[] res = new int[j - i + 1];
                for (int k = 0; k < res.length; k++) {
                    res[k] = k + i;
                }
                list.add(res);
                i++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    private int compareTo(int i, int j, int target) {
        int x = (i + ((j - i) >> 1)) * (j - i + 1);
        return (j - i) % 2 == 0 ? x - target : x + ((j - i + 1) >> 1) - target;
    }
}
