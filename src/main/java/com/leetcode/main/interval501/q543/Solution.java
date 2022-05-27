package com.leetcode.main.interval501.q543;

/**
 * 二叉树的直径
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-08
 */
public class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        dfsDiameter(root);
        return diameter;
    }

    private void dfsDiameter(TreeNode node) {
        int d = nodeDepth(node.left) + nodeDepth(node.right);
        if (d > diameter) diameter = d;
        if (node.left != null) dfsDiameter(node.left);
        if (node.right != null) dfsDiameter(node.right);
    }

    private int nodeDepth(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Math.max(nodeDepth(node.left), nodeDepth(node.right)) + 1;
    }

    /**
     * 优化算法
     * 将计算直径的部分直接嵌入到计算深度的算法中
     */
    private int dfsDepth(TreeNode node) {
        if (node == null) return 0;
        int lDepth = dfsDepth(node.left);
        int rDepth = dfsDepth(node.right);
        if (lDepth + rDepth > diameter) diameter = lDepth + rDepth;
        return Math.max(lDepth, rDepth) + 1;
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
