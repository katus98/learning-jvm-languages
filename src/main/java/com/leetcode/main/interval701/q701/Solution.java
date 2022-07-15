package com.leetcode.main.interval701.q701;

/**
 * 二叉搜索树中的插入操作
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Solution {
    /**
     * 迭代
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(val);
                    break;
                }
            } else {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }
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
