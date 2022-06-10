package com.leetcode.main.interval501.q572;

/**
 * 另一个树的子树
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-10
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (root.val == subRoot.val) {
            boolean res = dfs(root, subRoot);
            if (res) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (subRoot == null) return false;
        if (root.val == subRoot.val) {
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
        return false;
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
