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

    /**
     * 课程表
     * * 拓扑排序
     *
     * @see com.leetcode.main.interval201.q207.Solution
     */
    void canFinish();

    /**
     * 课程表 II
     * * 拓扑排序
     *
     * @see com.leetcode.main.interval201.q210.Solution
     */
    void findOrder();

    /**
     * 公交路线
     * * 构建线路网络 + BFS
     *
     * @see com.leetcode.main.interval801.q815.Solution
     */
    void numBusesToDestination();

    /**
     * 找到小镇的法官
     * * 统计每个节点的入度和出度
     *
     * @see com.leetcode.main.interval901.q997.Solution
     */
    void findJudge();

    /**
     * 省份数量
     * * DFS / BFS
     *
     * @see com.leetcode.main.interval501.q547.Solution
     */
    void findCircleNum();

    /**
     * 移除最多的同行或同列石头
     * * 将行列一致的点存储在一起
     *
     * @see com.leetcode.main.interval901.q947.Solution
     */
    void removeStones();

    /**
     * 可以到达所有点的最少点数目
     * * 相当于统计入度为0的点
     *
     * @see com.leetcode.main.interval1501.q1557.Solution
     */
    void findSmallestSetOfVertices();

    /**
     * 钥匙和房间
     * * DFS
     *
     * @see com.leetcode.main.interval801.q841.Solution
     */
    void canVisitAllRooms();
}
