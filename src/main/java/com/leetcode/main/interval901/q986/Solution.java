package com.leetcode.main.interval901.q986;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-14
 */
public class Solution {
    /**
     * 强大的原创算法
     * 优化的双层循环, 实际上和双指针的效率应该一样
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> resList = new ArrayList<>();
        int start, end, last = 0;
        for (int i = 0; i < firstList.length; i++) {
            for (int j = last; j < secondList.length; j++) {
                start = Math.max(firstList[i][0], secondList[j][0]);
                end = Math.min(firstList[i][1], secondList[j][1]);
                if (start <= end) {
                    resList.add(new int[]{start, end});
                    last = j;
                } else if (firstList[i][1] < secondList[j][0]) {
                    break;
                }
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

    /**
     * 双指针
     */
    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                ans.add(new int[]{start, end});
            }
            // 通过右边界大小决定移动哪一个区间
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
