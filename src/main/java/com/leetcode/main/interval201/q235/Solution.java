package com.leetcode.main.interval201.q235;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-25
 */
public class Solution {
    /**
     * 递归 如果都大于根从右节点开始找 如果都小于根从左节点开始找
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
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
