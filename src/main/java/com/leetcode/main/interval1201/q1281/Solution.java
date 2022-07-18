package com.leetcode.main.interval1201.q1281;

/**
 * 整数的各位积和之差
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-18
 */
public class Solution {
    /**
     * 普通的获取十进制位代码
     */
    public int subtractProductAndSum(int n) {
        if (n == 0) return 0;
        int a = 0, m = 1;
        while (n != 0) {
            int k = n % 10;
            a += k;
            m *= k;
            n /= 10;
        }
        return m - a;
    }
}
