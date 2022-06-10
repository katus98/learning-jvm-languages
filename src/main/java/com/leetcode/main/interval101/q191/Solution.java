package com.leetcode.main.interval101.q191;

/**
 * 位 1 的个数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-10
 */
public class Solution {
    /**
     * 循环检查二进制位
     */
    public int hammingWeight(int n) {
        int k = 1, count = 0;
        for (int i = 0; i < 32; i++) {
            if ((k & n) != 0) {
                count++;
            }
            k <<= 1;
        }
        return count;
    }

    /**
     * 每次去除最后一位1
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            // 每次去除最后一位1
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
