package com.leetcode.main.interval101.q112;

/**
 * 路径总和
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    /**
     * 注意是到叶子节点, 所以不能递归到null, 而是每次判断是否是叶子节点
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        int num = targetSum - root.val;
        return (root.left != null && hasPathSum(root.left, num)) || (root.right != null && hasPathSum(root.right, num));
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
