package com.leetcode.review;

/**
 * 搜索方法
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public interface Search {
    /**
     * 二分搜索法
     */
    interface BinarySearch {
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
         * 有效的完全平方数
         * * 最基本的二分查找
         *
         * @see com.leetcode.main.interval301.q367.Solution
         */
        void isPerfectSquare();

        /**
         * 两个数组间的距离值
         * * 情景下的二分查找
         *
         * @see com.leetcode.main.interval1301.q1385.Solution
         */
        void findTheDistanceValue();

        /**
         * x 的平方根
         * * 另一种二分法模式
         * * 不是寻找target而是寻找比target大或者小一点的元素
         * * 借助一个额外的变量存储结果, 循环条件start <= end, 分支都需要变化区间+-1
         *
         * @see com.leetcode.main.interval1.q69.Solution
         */
        void mySqrt();

        /**
         * 寻找比目标字母大的最小字母
         * * 另一种二分法模式
         * * 不是寻找target而是寻找比target大或者小一点的元素
         * * 借助一个额外的变量存储结果, 循环条件start <= end, 分支都需要变化区间+-1
         *
         * @see com.leetcode.main.interval701.q744.Solution
         */
        void nextGreatestLetter();

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

        /**
         * 第一个错误的版本
         * * 最基本的二分查找, 单向判断, 退出条件为查找结果
         *
         * @see com.leetcode.main.interval201.q278.Solution
         */
        void firstBadVersion();

        /**
         * 在排序数组中查找元素的第一个和最后一个位置
         * * 最基本的二分法
         *
         * @see com.leetcode.main.interval1.q34.Solution
         */
        void searchRange();

        /**
         * 排列硬币
         * * 最基本的单向二分法之中间值靠右
         *
         * @see com.leetcode.main.interval401.q441.Solution
         */
        void arrangeCoins();

        /**
         * 第 k 个缺失的正整数
         * * 结果等于缺失的数量 + 第一个满足大于缺失值的位置索引号
         * * 如果跳出循环的时候arr[start] - start - 1 >= k 不成立, 说明缺失值超过最后一个元素
         *
         * @see com.leetcode.main.interval1501.q1539.Solution
         */
        void findKthPositive();

        /**
         * 特殊数组的特征值
         * * 特别的二分法
         * * 倒序排列数组, 数组下标+1即为x是递增的, 数组值是递减的
         * * 通过二分法找到两者大小关系的交界处 (这个地方是唯一可能的特征值)
         * * 然后检验一下这个特征值是否有效即可
         *
         * @see com.leetcode.main.interval1601.q1608.Solution
         */
        void specialArray();

        /**
         * 搜索二维矩阵
         * * 将二维矩阵映射到一维数组然后二分
         *
         * @see com.leetcode.main.interval1.q74.Solution
         */
        void searchMatrix();

        /**
         * 矩阵中战斗力最弱的 K 行
         * * 多个单向二分查找组合 + 统计
         *
         * @see com.leetcode.main.interval1301.q1337.Solution
         */
        void kWeakestRows();

        /**
         * 检查整数及其两倍数是否存在
         * * 要注意二分时正负处理逻辑不同
         *
         * @see com.leetcode.main.interval1301.q1346.Solution
         */
        void checkIfExist();

        /**
         * 寻找旋转排序数组中的最小值
         * * 通过比较中间值和右侧界限值的大小进行二分
         *
         * @see com.leetcode.main.interval101.q153.Solution
         */
        void findMin();
    }

    /**
     * 双指针逼近
     */
    interface DoublePointerApproximation {
        /**
         * 两数之和 II - 输入有序数组
         * * 最基本的双指针逼近
         *
         * @see com.leetcode.main.interval101.q167.Solution
         */
        void twoSum2();
    }

    /**
     * 记忆化搜索
     */
    interface MemoizedSearch {
        /**
         * 零钱兑换
         * * 结果数组 (记忆) 表示金额为i + 1的情况需要的最小零钱数量, 如果为0说明还没有计算
         *
         * @see com.leetcode.main.interval301.q322.Solution
         */
        void coinChange();
    }
}
