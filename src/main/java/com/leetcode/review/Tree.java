package com.leetcode.review;

/**
 * 树
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-12
 */
public interface Tree {
    /**
     * 树的遍历
     *
     * @see com.leetcode.main.interval101.q144.Solution
     * @see com.leetcode.main.interval1.q94.Solution
     * @see com.leetcode.main.interval101.q145.Solution
     * @see com.leetcode.main.interval101.q102.Solution
     * @see com.leetcode.main.interval501.q589.Solution
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

    /**
     * 翻转二叉树
     * * 递归 左右节点结果交换位置
     *
     * @see com.leetcode.main.interval201.q226.Solution
     */
    void invertTree();

    /**
     * 路径总和
     * * 递归 注意递归出口是叶子节点而不是null节点
     *
     * @see com.leetcode.main.interval101.q112.Solution
     */
    void hasPathSum();

    /**
     * 二叉搜索树中的搜索
     * * 递归 根据大小判断子节点选择
     *
     * @see com.leetcode.main.interval601.q700.Solution
     */
    void searchBST();

    /**
     * 二叉搜索树中的插入操作
     * * 迭代
     *
     * @see com.leetcode.main.interval701.q701.Solution
     */
    void insertIntoBST();

    /**
     * 二叉搜索树的最近公共祖先
     * * 递归 如果都大于根从右节点开始找 如果都小于根从左节点开始找
     *
     * @see com.leetcode.main.interval201.q235.Solution
     */
    void lowestCommonAncestor();

    /**
     * 验证二叉搜索树
     * * 中序遍历并验证顺序
     *
     * @see com.leetcode.main.interval1.q98.Solution
     */
    void isValidBST();
}
