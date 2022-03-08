package com.leetcode.offer.q10;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 */
public class Solution {
    /**
     * 传统递归解法, 时空复杂度较高
     */
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n <= 1) {
            return n;
        } else {
            return (fib(n - 1) + fib(n - 2)) % MOD;
        }
    }

    /**
     * 动态规划, 迭代方式进行, 每次仅保留前两次的计算结果
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        } else {
            final int MOD = 1000000007;
            int r1 = 0, r2 = 1, r3 = 0;
            for (int i = 2; i <= n; i++) {
                r3 = (r1 + r2) % MOD;
                r1 = r2;
                r2 = r3;
            }
            return r3;
        }
    }
}
