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
}
