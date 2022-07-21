package com.leetcode.main.interval1201.q1232;

import java.util.HashSet;
import java.util.Set;

/**
 * 缀点成线
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-21
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point = coordinates[0];
        Set<String> set = new HashSet<>();
        for (int i = 1; i < coordinates.length; i++) {
            int[] point2 = coordinates[i];
            int deltaX = point[0] - point2[0];
            int deltaY = point[1] - point2[1];
            int g = gcd(Math.abs(deltaX), Math.abs(deltaY));
            deltaX /= g;
            deltaY /= g;
            String key = Math.abs(deltaX) + "_" + Math.abs(deltaY);
            if (deltaX * deltaY < 0) {
                key = "-" + key;
            }
            set.add(key);
            // 短路优化
            if (set.size() > 1) return false;
        }
        return set.size() == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
