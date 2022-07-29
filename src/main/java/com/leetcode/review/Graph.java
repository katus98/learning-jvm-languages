package com.leetcode.review;

/**
 * 图
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-29
 */
public interface Graph {
    /**
     * K 站中转内最便宜的航班
     * * BFS
     *
     * @see com.leetcode.main.interval701.q787.Solution
     */
    void findCheapestPrice();

    /**
     * 不邻接植花
     * * 遍历每个节点的每条边, 填充一个不重复的数值
     *
     * @see com.leetcode.main.interval1001.q1042.Solution
     */
    void gardenNoAdj();
}
