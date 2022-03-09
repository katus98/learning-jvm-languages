package com.leetcode.offer.q14;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-09
 */
public class Solution2 {
    private final int MOD = 1000000007;
    /**
     * 求余运算规则: 设正整数 x, y, p, 求余符号为⊙, 则有
     * (x+y)⊙p=(x⊙p+y⊙p)⊙p
     * (xy)⊙p=[(x⊙p)(y⊙p)]⊙p
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n / 3, a = n % 3;
        switch (a) {
            case 0:
                return (int) myPow(3, b);
            case 1:
                return (int) ((myPow(3, b - 1) * 4) % MOD);
            case 2:
                return (int) ((myPow(3, b) * 2) % MOD);
        }
        return 1;
    }

    private long myPow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        long result = x;
        for (int i = 1; i < n; i++) {
            result = (result * x) % MOD;
        }
        return result;
    }
}
