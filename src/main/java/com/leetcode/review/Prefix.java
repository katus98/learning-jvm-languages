package com.leetcode.review;

/**
 * 涵盖前后缀思想的相关问题
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-04
 */
public interface Prefix {
    /**
     * 和为 K 的子数组
     * * 前缀和 + 哈希表
     *
     * @see com.leetcode.main.interval501.q560.Solution
     */
    void subarraySum();

    /**
     * 递增的三元子序列
     * * 前后缀最值
     *
     * @see com.leetcode.main.interval301.q334.Solution
     */
    void increasingTriplet();

    /**
     * 除自身以外数组的乘积
     * * 前后缀乘积
     *
     * @see com.leetcode.main.interval201.q238.Solution
     */
    void productExceptSelf();
}
