package com.leetcode.review;

/**
 * 树
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-12
 */
public interface Tree {
    /**
     * 树的遍历 (递归/迭代)
     *
     * @see com.leetcode.main.interval101.q144.Solution
     * @see com.leetcode.main.interval1.q94.Solution
     * @see com.leetcode.main.interval101.q145.Solution
     * @see com.leetcode.main.interval101.q102.Solution
     * @see com.leetcode.main.interval501.q589.Solution
     * @see com.leetcode.main.interval101.q173.BSTIterator
     * @see com.leetcode.main.interval401.q429.Solution
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
     * 路径总和 II
     * * 回溯
     *
     * @see com.leetcode.main.interval101.q113.Solution
     */
    void pathSum2();

    /**
     * 路径总和 III
     * * 双层递归, 外层遍历每个节点, 内层遍历以当前节点作为根的每条路径
     *
     * @see com.leetcode.main.interval401.q437.Solution
     */
    void pathSum3();

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

    /**
     * 二叉搜索树中第K小的元素
     * * 中序遍历提前返回
     *
     * @see com.leetcode.main.interval201.q230.Solution
     */
    void kthSmallest();

    /**
     * 平衡二叉树
     * * 递归返回高度, 如果不合法返回-1
     *
     * @see com.leetcode.main.interval101.q110.Solution
     */
    void isBalanced();

    /**
     * 二叉树的直径
     * * 递归计算左右节点的深度, 计算过程中更新结果
     *
     * @see com.leetcode.main.interval501.q543.Solution
     */
    void diameterOfBinaryTree();

    /**
     * 将有序数组转换为二叉搜索树
     * * 反向中序遍历 + 二分
     *
     * @see com.leetcode.main.interval101.q108.Solution
     */
    void sortedArrayToBST();

    /**
     * 相同的树
     * * 递归
     *
     * @see com.leetcode.main.interval1.q100.Solution
     */
    void isSameTree();

    /**
     * 从前序与中序遍历序列构造二叉树
     * * 递归
     *
     * @see com.leetcode.main.interval101.q105.Solution
     */
    void buildTree();

    /**
     * 二叉树的锯齿形层序遍历
     * * 遍历本身是普通的层序遍历, 但是放入结果方向会根据层次的奇偶变化(双端队列)
     *
     * @see com.leetcode.main.interval101.q103.Solution
     */
    void zigzagLevelOrder();

    /**
     * 二叉树的右视图
     * * 层序遍历, 每次循环都遍历一层, 记录当前层的最右侧节点值
     * * 深度优先遍历(根->右->左), 遍历结果最前面的几个就是(有几层就有几个)
     *
     * @see com.leetcode.main.interval101.q199.Solution
     */
    void rightSideView();

    /**
     * 删除二叉搜索树中的节点
     * * 模拟 + 递归
     *
     * @see com.leetcode.main.interval401.q450.Solution
     */
    void deleteNode();

    /**
     * 二叉树的序列化与反序列化
     * * 遍历, 但是包含一层null
     *
     * @see com.leetcode.main.interval201.q297.Codec
     * @see com.leetcode.offer.q37.Codec
     */
    void codec();

    /**
     * 二叉树中的列表
     * * 遍历每个位置, 如果位置符合条件验证节点一一对应相等
     *
     * @see com.leetcode.main.interval1301.q1367.Solution
     */
    void isSubPath();
}
