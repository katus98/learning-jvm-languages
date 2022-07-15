package com.leetcode.exam.autumn.pre.microsoft;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 统计在一条直线上的三点组数量
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Task3 {
    public int solution(Point2D[] A) {
        List<Integer> lineList = new ArrayList<>();
        Map<Integer, Set<String>> checkedMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Point2D point1 = A[i];
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < A.length; j++) {
                Point2D point2 = A[j];
                int deltaX = point1.x - point2.x;
                int deltaY = point1.y - point2.y;
                int g = gcd(Math.abs(deltaX), Math.abs(deltaY));
                String key = Math.abs(deltaX / g) + "_" + Math.abs(deltaY / g);
                if (deltaX * deltaY < 0) {
                    key = "-" + key;
                }
                if (!checkedMap.containsKey(j) || !checkedMap.get(j).contains(key)) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    if (!checkedMap.containsKey(j)) {
                        Set<String> keys = new HashSet<>();
                        keys.add(key);
                        checkedMap.put(j, keys);
                    } else {
                        checkedMap.get(j).add(key);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    lineList.add(entry.getValue() + 1);
                }
            }
        }
        long res = 0;
        for (int pNum : lineList) {
            res += combine3(pNum);
        }
        return res > 100000000L ? -1 : (int) res;
    }

    private long combine3(long n) {
        return n * (n - 1) * (n - 2) / 6;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    @AllArgsConstructor
    public static class Point2D {
        public int x;
        public int y;
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.solution(new Point2D[]{new Point2D(0, 0), new Point2D(1, 1), new Point2D(2, 2), new Point2D(3, 3),
                new Point2D(3, 2), new Point2D(4, 2), new Point2D(5, 1), new Point2D(1, 10), new Point2D(2, 10), new Point2D(10, 10)}));
    }
}
