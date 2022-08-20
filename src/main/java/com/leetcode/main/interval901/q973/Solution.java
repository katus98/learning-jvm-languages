package com.leetcode.main.interval901.q973;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最接近原点的 K 个点
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointDis> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o2.dis, o1.dis));
        for (int[] point : points) {
            if (queue.size() < k) {
                queue.offer(new PointDis(point));
            } else {
                long dis = (long) point[0] * point[0] + (long) point[1] * point[1];
                if (dis < queue.peek().dis) {
                    queue.poll();
                    queue.offer(new PointDis(point));
                }
            }
        }
        int[][] resArr = new int[queue.size()][];
        int i = 0;
        while (!queue.isEmpty()) {
            resArr[i++] = queue.poll().point;
        }
        return resArr;
    }

    public static class PointDis {
        int[] point;
        long dis;

        public PointDis(int[] point) {
            this.point = point;
            this.dis = (long) point[0] * point[0] + (long) point[1] * point[1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
