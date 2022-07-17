package com.leetcode.main.interval1401.q1491;

/**
 * 去掉最低工资和最高工资后的工资平均值
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-17
 */
public class Solution {
    /**
     * 统计最值
     */
    public double average(int[] salary) {
        int minSal = Integer.MAX_VALUE, maxSal = Integer.MIN_VALUE;
        double total = 0;
        for (int sal : salary) {
            if (sal < minSal) {
                minSal = sal;
            }
            if (sal > maxSal) {
                maxSal = sal;
            }
            total += sal;
        }
        return (total - minSal - maxSal) / (salary.length - 2);
    }
}
