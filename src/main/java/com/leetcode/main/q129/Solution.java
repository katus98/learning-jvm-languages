package com.leetcode.main.q129;

/**
 * 求根节点到叶节点数字之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-05
 */
public class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        if (root != null) {
            dfs(root, 0);
        }
        return sum;
    }

    private void dfs(TreeNode root, int number) {
        number = number * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += number;
        } else {
            if (root.left != null) {
                dfs(root.left, number);
            }
            if (root.right != null) {
                dfs(root.right, number);
            }
        }
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
