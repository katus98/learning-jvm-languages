package com.leetcode.offer.q14;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-09
 */
public class Solution {
    /**
     * 数学推导或者贪心推导
     * 根据推导可以得出, 尽可能每段绳子相等且接近e, 整数就是3, 有少部分边界条件
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        if (n == 4) {
            return n;
        }
        int b = n / 3, a = n % 3;
        switch (a) {
            case 0:
                return (int) Math.pow(3, b);
            case 1:
                return ((int) Math.pow(3, b - 1)) * 4;
            case 2:
                return ((int) Math.pow(3, b)) * 2;
        }
        return 1;
    }
}
