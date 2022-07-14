package com.leetcode.review;

/**
 * 树
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-12
 */
public interface Tree {
    /**
     * 二叉树的遍历
     *
     * @see com.leetcode.main.interval101.q144.Solution
     * @see com.leetcode.main.interval1.q94.Solution
     * @see com.leetcode.main.interval101.q145.Solution
     * @see com.leetcode.main.interval101.q102.Solution
     */
    void traversal();

    /**
     * 二叉树的最大深度
     * * 递归, 左右子树的最大深度 + 1
     *
     * @see com.leetcode.main.interval101.q104.Solution
     */
    void maxDepth();

    /**
     * 对称二叉树
     * * 递归 判断左右对称位置是否相等
     *
     * @see com.leetcode.main.interval101.q101.Solution
     */
    void isSymmetric();
}
