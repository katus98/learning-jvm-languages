package com.leetcode.main.interval601.q700;

/**
 * 二叉搜索树中的搜索
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Solution {
    /**
     * 递归
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
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
