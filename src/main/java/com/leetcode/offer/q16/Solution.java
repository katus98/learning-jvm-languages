package com.leetcode.offer.q16;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {
    /**
     * 暴力计算会超时
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double result = 1.0;
        int abn = n < 0 ? -n : n;
        for (int i = 0; i < abn; i++) {
            result *= x;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 自创的二分法加快速度, 实际上就是将x^n变换为两个x^n/2, 同时注意奇偶控制
     */
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        int abn = n < 0 ? -n : n;
        double result = positivePow(x, abn);
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    private double positivePow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        int a = n / 2, q = n % 2;
        double result = positivePow(x, a);
        return q == 0 ? result * result : result * result * x;
    }

    /**
     * 快速幂算法, 借助位运算
     */
    public double myPow3(double x, int n) {
        if (x == 0) return 0;
        // 边界进行相反数运算时会超出界限, 需要通过long承接
        long b = n;
        double result = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) result *= x;
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
