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
     * 山脉数组的峰顶索引
     * * 最基本的二分查找
     *
     * @see com.leetcode.main.interval801.q852.Solution
     */
    void peakIndexInMountainArray();

    /**
     * 搜索插入位置
     * * 最基本的二分查找
     * * 记录的这个二分法模板退出迭代的只可能是找到目标值或者没找到start == end == 比target大一点的数的位置两种情况之一
     * * 但是要注意: 后一种情况在target大于所有的值的时候例外, 此时start == end == nums.length - 1
     * * 所以最后当结果是最后一个位置时需要判断是当前位置还是插在整个数组的后面
     *
     * @see com.leetcode.main.interval1.q35.Solution
     */
    void searchInsert();

    /**
     * 搜索旋转排序数组
     * * 二分查找, 每次二分可以分成一个递增序列和一个不完全递增序列, 不完全的继续递归
     *
     * @see com.leetcode.main.interval1.q33.Solution
     */
    void searchRotateArray();
}
