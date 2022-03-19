package com.leetcode.offer.q55;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 */
public class Solution2 {
    /**
     * 理解错误
     */
    public boolean isBalanced_1(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) {
            return isBalanced_1(root.left) && isBalanced_1(root.right);
        } else if (root.left != null) {
            return root.left.left == null && root.left.right == null;
        } else if (root.right != null) {
            return root.right.left == null && root.right.right == null;
        } else {
            return true;
        }
    }

    /**
     * 前序遍历, 其中节点的高度被重复计算, 可以考虑用map记录一下
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 树节点的深度
     */
    private int depth(TreeNode node) {
        return node == null ? 0 : Math.max(depth(node.left), depth(node.right)) + 1;
    }

    /**
     * 后序遍历, 减少无用调用
     */
    public boolean isBalanced2(TreeNode root) {
        return heightB(root) >= 0;
    }

    private int heightB(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = heightB(node.left);
        int rightHeight = heightB(node.right);
        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
