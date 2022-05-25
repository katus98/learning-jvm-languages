package com.leetcode.offer.q68;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-25
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getSameParent(root, p.val, q.val);
    }

    private TreeNode getSameParent(TreeNode root, int pVal, int qVal) {
        if (root == null) return null;
        if (root.val > pVal && root.val > qVal) {
            return getSameParent(root.left, pVal, qVal);
        } else if (root.val < pVal && root.val < qVal) {
            return getSameParent(root.right, pVal, qVal);
        } else {
            return root;
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
