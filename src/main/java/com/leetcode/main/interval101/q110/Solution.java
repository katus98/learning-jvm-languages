package com.leetcode.main.interval101.q110;

import com.leetcode.offer.q55.Solution2;

/**
 * 平衡二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 * @see Solution2
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return heightB(root) >= 0;
    }

    private int heightB(TreeNode node) {
        if (node == null) return 0;
        int heightLeft = heightB(node.left);
        int heightRight = heightB(node.right);
        if (heightLeft == -1 || heightRight == -1 || Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }
        return Math.max(heightLeft, heightRight) + 1;
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
