package com.leetcode.offer.q10;

import java.math.BigInteger;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 */
public class Solution2 {
    private final int MOD = 1000000007;

    /**
     * 因为中间结果数值很大, 所以借用了科学计算API来实现计算过程, 不推荐
     */
    public int numWays(int n) {
        BigInteger count = new BigInteger("0");
        BigInteger whole = new BigInteger(String.valueOf(n)), maxTwo = whole.divide(new BigInteger("2"));
        for (BigInteger two = maxTwo; two.compareTo(new BigInteger("0")) >= 0; two = two.subtract(new BigInteger("1"))) {
            BigInteger one = whole.subtract(two.multiply(new BigInteger("2")));
            count = count.add(combine(one.add(two), one));
        }
        count = count.mod(new BigInteger(String.valueOf(MOD)));
        return Integer.parseInt(count.toString());
    }

    private BigInteger combine(BigInteger n, BigInteger m) {
        return fun(n).divide(fun(n.subtract(m))).divide(fun(m));
    }

    private BigInteger fun(BigInteger n) {
        return n.compareTo(new BigInteger("1")) <= 0 ? new BigInteger("1") : n.multiply(fun(n.subtract(new BigInteger("1"))));
    }

    /**
     * 动态规划: 青蛙最后一步只能跳两节或者一节, 所以 f(n) = f(n-1) + f(n-2)
     * 扩展: 如果每次青蛙最多可以跳m节呢?
     */
    public int numWays2(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int r1 = 1, r2 = 1, r3 = 0;
            for (int i = 2; i <= n; i++) {
                r3 = (r1 + r2) % MOD;
                r1 = r2;
                r2 = r3;
            }
            return r3;
        }
    }
}
