package com.leetcode.main.interval101.q111;

/**
 * 二叉树的最小深度
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-21
 */
public class Solution {
    /**
     * 注意叶子节点是左右都是null
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        }
        return minDepth(root.right) + 1;
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
