package com.leetcode.review;

/**
 * 位运算
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-29
 */
public interface BitOperation {
    /**
     * 数字范围按位与
     * * 两个边界数值同时右移直至相等再左移补0 n >>= 1
     * * 不断去除右边界最右侧的0直至小于左边界 n & (n - 1)
     *
     * @see com.leetcode.main.interval201.q201.Solution
     */
    void rangeBitwiseAnd();

    /**
     * 位 1 的个数
     * * 循环检查二进制位 1 左移 与 原始值
     * * 每次去除最后一位1, 统计次数
     *
     * @see com.leetcode.main.interval101.q191.Solution
     */
    void hammingWeight();
}
