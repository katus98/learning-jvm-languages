package com.leetcode.main.interval101.q190;

/**
 * 颠倒二进制位
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-11
 */
public class Solution {
    public int reverseBits(int n) {
        int r = 0, k = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & k) != 0) {
                r += (1 << (32 - i - 1));
            }
            k <<= 1;
        }
        return r;
    }
}
