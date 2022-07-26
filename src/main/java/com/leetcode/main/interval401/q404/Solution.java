package com.leetcode.main.interval401.q404;

/**
 * 左叶子之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-26
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return preOrder(root);
    }

    public int preOrder(TreeNode node) {
        if (node != null) {
            int res = 0;
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
            }
            res += preOrder(node.left);
            res += preOrder(node.right);
            return res;
        } else return 0;
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
