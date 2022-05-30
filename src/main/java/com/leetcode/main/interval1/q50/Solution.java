package com.leetcode.main.interval1.q50;

/**
 * Pow(x, n)
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 * @see com.leetcode.offer.q16.Solution
 */
public class Solution {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        // 边界进行相反数运算时会超出界限, 需要通过long承接
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double result = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) result *= x;
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
