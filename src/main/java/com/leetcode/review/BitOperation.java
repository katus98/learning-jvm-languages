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
}
