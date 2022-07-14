package com.leetcode.main.interval201.q226;

/**
 * 翻转二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 * @see com.leetcode.offer.q27.Solution
 */
public class Solution {
    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
