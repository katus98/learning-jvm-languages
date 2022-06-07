package com.leetcode.main.interval1.q7;

/**
 * 整数反转
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-07
 */
public class Solution {
    /**
     * 逐位处理
     */
    public int reverse(int x) {
        int a, n = 0;
        while (x != 0) {
            a = x % 10;
            x /= 10;
            if (n > Integer.MAX_VALUE / 10 || (n == Integer.MAX_VALUE / 10 && a > Integer.MAX_VALUE - 10 * n)) {
                return 0;
            }
            if (n < Integer.MIN_VALUE / 10 || (n == Integer.MIN_VALUE / 10 && a < Integer.MIN_VALUE - 10 * n)) {
                return 0;
            }
            n = 10 * n + a;
        }
        return n;
    }
}
