package com.leetcode.main.interval201.q218;

import java.util.*;

/**
 * 天际线问题
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-30
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> resList = new ArrayList<>();

        // 预处理所有的点, 为了方便排序, 对于左端点, 令高度为负; 对于右端点令高度为正
        List<int[]> buildingEdges = new ArrayList<>();
        for (int[] building : buildings) {
            int l = building[0], r = building[1], h = building[2];
            buildingEdges.add(new int[]{l, -h});
            buildingEdges.add(new int[]{r, h});
        }

        // 先按照横坐标进行排序, 如果相同按照高度进行排序 (保证横坐标递增, 然后同一位置左端点在前右端点在后)
        buildingEdges.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        // 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int prevHeight = 0;
        heap.add(prevHeight);
        for (int[] edge : buildingEdges) {
            int point = edge[0], height = edge[1];
            if (height < 0) {
                // 如果是左端点, 说明存在一条往右延伸的可记录的边, 将高度存入优先队列
                heap.add(-height);
            } else {
                // 如果是右端点, 说明这条边结束了, 将当前高度从队列中移除
                heap.remove(height);
            }

            // 取出最高高度, 如果当前不与前一矩形“上边”延展而来的那些边重合, 则可以被记录
            int maxHeight = heap.peek();
            if (maxHeight != prevHeight) {
                resList.add(Arrays.asList(point, maxHeight));
                prevHeight = maxHeight;
            }
        }
        return resList;
    }
}
