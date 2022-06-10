package com.leetcode.main.interval201.q231;

/**
 * 2 的幂
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-10
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        int  k = 1;
        for (int i = 0; i < 32; i++) {
            if (k == n) return true;
            k <<= 1;
        }
        return false;
    }

    /**
     * 位运算
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
