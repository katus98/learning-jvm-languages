package com.leetcode.main.interval201.q230;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-05
 */
public class Solution {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.result = -1;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (count-- == 1) {
                this.result = root.val;
                return;
            }
            inorder(root.right);
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
