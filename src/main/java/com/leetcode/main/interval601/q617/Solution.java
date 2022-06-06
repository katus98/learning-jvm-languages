package com.leetcode.main.interval601.q617;

/**
 * 合并二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-06
 */
public class Solution {
    /**
     * 递归处理
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode root;
        if (root1 != null && root2 != null) {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            root = new TreeNode(root1.val);
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        } else {
            root = new TreeNode(root2.val);
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
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
