package com.leetcode.main.interval601.q633;

/**
 * 平方数之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-01
 */
public class Solution {
    /**
     * 优化的双循环 (但是仍然会超时)
     * 思想: 考虑符合题意条件的三个数可以组成直角三角形, 组成三角形的特性可以排除一些情况
     * 需要额外考虑0
     */
    public boolean judgeSquareSum(int c) {
        if (c == 0) return true;
        double third = Math.sqrt(c);
        for (int b = 0; b < third; b++) {
            for (int a = Math.max(b, (int) third - b); a <= third + b; a++) {
                if (a * a + b * b == c) return true;
            }
        }
        return false;
    }

    /**
     * 单层循环, 另一个数开根号判断是不是整数
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a < Math.sqrt(c); a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    /**
     * 双指针, 两端向中间逼近
     */
    public boolean judgeSquareSum3(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            long r = (long) a * a + (long) b * b;
            if (r < c) {
                a++;
            } else if (r > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(4));
    }
}
