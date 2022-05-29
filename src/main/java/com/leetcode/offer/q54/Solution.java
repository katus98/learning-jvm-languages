package com.leetcode.offer.q54;

/**
 * 二叉搜索树的第k大节点
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 */
public class Solution {
    private int n, count, res;

    public int kthLargest(TreeNode root, int k) {
        this.n = k;
        this.count = 0;
        this.res = 0;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.right);
            if (++count == n) {
                this.res = node.val;
                return;
            }
            inOrder(node.left);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
