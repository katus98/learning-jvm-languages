package com.leetcode.offer.q68;

import com.leetcode.main.interval201.q236.Solution;

/**
 * 二叉树的最近公共祖先
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-25
 * @see Solution
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        boolean leftP = find(root.left, p);
        boolean leftQ = find(root.left, q);
        if (leftP && leftQ) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (!leftP && !leftQ) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    private boolean find(TreeNode root, TreeNode node) {
        return root == null ? node == null : root == node || find(root.left, node) || find(root.right, node);
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
