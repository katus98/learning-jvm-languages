package com.leetcode.review;

/**
 * 贪心算法
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-25
 */
public interface GreedyAlgorithm {
    /**
     * 跳跃游戏
     * * 贪心: 维护一个当前可以到达的最远距离时刻更新, 一旦不能到达则之后的都不能到达
     *
     * @see com.leetcode.main.interval1.q55.Solution
     */
    void canJump();

    /**
     * 跳跃游戏 II
     * * 贪心: 维护一个当前可以到达的最远距离时刻更新, 和本轮跳跃可以到达的最远位置
     *
     * @see com.leetcode.main.interval1.q45.Solution
     */
    void canJump2();

    /**
     * 无重叠区间
     * * 逆向思维: 寻找不重叠的区间序列最大个数
     * * 贪心: 维护一个当前最左侧区间的右边界, 如果不重叠就更新最左侧区间
     *
     * @see com.leetcode.main.interval401.q435.Solution
     */
    void eraseOverlapIntervals();

    /**
     * 递增的三元子序列
     * * 前后缀最值
     *
     * @see com.leetcode.main.interval301.q334.Solution
     */
    void increasingTriplet();

    /**
     * 划分字母区间
     * * 贪心记录每个字符出现的最后一个位置
     *
     * @see com.leetcode.main.interval701.q763.Solution
     */
    void partitionLabels();
}
