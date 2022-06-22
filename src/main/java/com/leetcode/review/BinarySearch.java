package com.leetcode.review;

/**
 * 二分查找
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public interface BinarySearch {
    /**
     * 二分查找
     * * 最基本的二分查找
     *
     * @see com.leetcode.main.interval701.q704.Solution
     */
    void search();

    /**
     * 猜数字大小
     * * 最基本的二分查找
     *
     * @see com.leetcode.main.interval301.q374.Solution
     */
    void guessNumber();

    /**
     * 搜索旋转排序数组
     * * 二分查找, 每次二分可以分成一个递增序列和一个不完全递增序列, 不完全的继续递归
     *
     * @see com.leetcode.main.interval1.q33.Solution
     */
    void searchRotateArray();
}
