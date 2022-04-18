package com.leetcode.main.q124;

/**
 * 二叉树中的最大路径和
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-18
 */
public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumNode(root);
        return maxSum;
    }

    private int maxSumNode(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(maxSumNode(root.left), 0);
        int rightSum = Math.max(maxSumNode(root.right), 0);
        int all = leftSum + root.val + rightSum;
        // 如果最大路径和中的根是当前的节点root的话
        this.maxSum = Math.max(maxSum, all);
        // 如果当前节点不是根, 只能作为路径中的一部分的话, 则只能选择两个子节点中路径大的一条
        return root.val + Math.max(leftSum, rightSum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
