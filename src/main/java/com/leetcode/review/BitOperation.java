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

    /**
     * 只出现一次的数字
     * * 所有的数异或运算, 相同的数两两消除, 剩下唯一的数
     *
     * @see com.leetcode.main.interval101.q136.Solution
     */
    void singleNumber();

    /**
     * 比特位计数
     * * DP: dp[i] = dp[i - highBit] + 1;
     *
     * @see com.leetcode.main.interval301.q338.Solution
     */
    void countBits();

    /**
     * 汉明距离
     * * 按位亦或
     *
     * @see com.leetcode.main.interval401.q461.Solution
     */
    void hammingDistance();

    /**
     * 格雷编码
     * * 对称生成, 在原有序列的基础上镜像向右翻转一倍, 然后将翻转出来的最高位变成1
     */
    void grayCode();
}
