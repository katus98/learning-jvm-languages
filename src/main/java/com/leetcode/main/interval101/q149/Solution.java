package com.leetcode.main.interval101.q149;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public class Solution {
    /**
     * 双层循环 + Map统计斜率数量
     * 外层循环选择起点, 内层循环选择与起点连线, 求斜率, 放入哈希表统计数量
     */
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int res = 0;
        // 双层循环
        for (int i = 0; i < points.length; i++) {
            // 如果结果已经超过未遍历的点数或者已经超过总点数的半数则可以提前结束
            if (res >= points.length - i || res > points.length / 2) {
                break;
            }
            int[] point1 = points[i];
            // 将斜率放到map中统计数量
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int delX = point1[0] - point2[0];
                int delY = point1[1] - point2[1];
                int gcd = gcd(Math.abs(delX), Math.abs(delY));
                if (gcd != 0) {
                    delX /= gcd;
                    delY /= gcd;
                }
                String key = Math.abs(delX) + "_" + Math.abs(delY);
                if (delX * delY < 0) {
                    key = "-" + key;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                res = Math.max(res, 1 + entry.getValue());
            }
        }
        return res;
    }

    /**
     * 最大公约数
     */
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
