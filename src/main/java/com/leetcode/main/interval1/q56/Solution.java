package com.leetcode.main.interval1.q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-21
 */
public class Solution {
    /**
     * 将区间按照左边界从小到大排序, 然后依次放入到结果中, 每次比较当前区间和所有的结果区间(相对较慢)
     */
    public int[][] merge(int[][] intervals) {
        boolean merged;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            merged = false;
            for (int[] ints : intervalList) {
                if ((interval[0] - ints[1]) * (interval[1] - ints[0]) <= 0) {
                    ints[0] = Math.min(ints[0], interval[0]);
                    ints[1] = Math.max(ints[1], interval[1]);
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                intervalList.add(interval);
            }
        }
        return intervalList.toArray(new int[0][]);
    }

    /**
     * 将区间按照左边界从小到大排序, 然后依次放入到结果中, 每次比较当前区间和结果中最后一个区间是否重叠, 如果重叠则合并, 否则加入新区间
     */
    public int[][] merge2(int[][] intervals) {
        boolean merged;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            merged = false;
            if (!intervalList.isEmpty() && interval[0] <= intervalList.get(intervalList.size() - 1)[1]) {
                intervalList.get(intervalList.size() - 1)[1] = Math.max(intervalList.get(intervalList.size() - 1)[1], interval[1]);
                merged = true;
            }
            if (!merged) {
                intervalList.add(interval);
            }
        }
        return intervalList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        });
    }
}
