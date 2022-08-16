package com.leetcode.main.interval1.q57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-16
 */
public class Solution {
    /**
     * 按照左边界放入数组, 然后合并区间
     *
     * @see com.leetcode.main.interval1.q56.Solution
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][0]) {
                index = i;
                break;
            }
        }
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(Arrays.copyOfRange(intervals, 0, index)));
        int[] interval = newInterval;
        boolean merge = false;
        if (!list.isEmpty() && list.get(list.size() - 1)[1] >= interval[0]) {
            list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            merge = true;
        }
        if (!merge) {
            list.add(interval);
        }
        for (int i = index; i < intervals.length; i++) {
            merge = false;
            interval = intervals[i];
            if (!list.isEmpty() && list.get(list.size() - 1)[1] >= interval[0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
                merge = true;
            }
            if (!merge) {
                list.add(interval);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
