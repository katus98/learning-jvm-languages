package com.leetcode.offer.q15;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {
    /**
     * 位运算改变世界
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * n & (n−1), 其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果
     * 重复这一操作, 直至n为0, 操作的次数即为1的位数
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
