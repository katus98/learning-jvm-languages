package com.leetcode.review;

/**
 * 其他算法
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public interface Others {
    /**
     * 打乱数组
     * * Fisher-Yates 洗牌算法
     *
     * @see com.leetcode.main.interval301.q384.Solution
     */
    void shuffle();

    /**
     * 快乐数
     * * 哈希
     *
     * @see com.leetcode.main.interval201.q202.Solution
     */
    void isHappy();

    /**
     * 直线上最多的点数
     * * 双层循环 + Map统计数量
     *
     * @see com.leetcode.main.interval101.q149.Solution
     */
    void maxPoints();
}
