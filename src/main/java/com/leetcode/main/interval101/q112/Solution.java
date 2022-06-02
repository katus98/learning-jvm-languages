package com.leetcode.main.interval101.q112;

/**
 * 路径总和
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return (root.left != null && hasPathSum(root.left, targetSum - root.val)) || (root.right != null && hasPathSum(root.right, targetSum - root.val));
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
