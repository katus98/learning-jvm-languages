package com.leetcode.review;

/**
 * 堆
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-05
 */
public interface Heap {
    /**
     * 数组中第 k 个最大元素
     * * 维护容量为k的最小堆, 不小于堆顶放入, 最终堆顶就是答案
     *
     * @see com.leetcode.main.interval201.q215.Solution
     */
    void findKthLargest();

    /**
     * 前 K 个高频元素
     * * 哈希表统计数量 + K容量最小堆
     *
     * @see com.leetcode.main.interval301.q347.Solution
     */
    void topKFrequent();
}
