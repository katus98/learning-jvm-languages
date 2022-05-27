package com.leetcode.main.interval201.q236;

import com.leetcode.offer.q68.Solution2;

/**
 * 二叉树的最近公共祖先
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-05
 * @see Solution2
 */
public class Solution {

    /**
     * 以root为根的二叉树中pq的最近公共结点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode node;
        node = lowestCommonAncestor(root.left, p, q);
        if (node == null) {
            node = lowestCommonAncestor(root.right, p, q);
        }
        if (node == null && findNode(root, p) && findNode(root, q)) {
            node = root;
        }
        return node;
    }

    /**
     * 沿着root根向下是否可以找到node
     */
    private boolean findNode(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return findNode(root.left, node) || findNode(root.right, node);
    }

    private TreeNode ans = null;

    /**
     * 沿着root向下是否存在q或者p
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean son1 = dfs(root.left, p, q);
        boolean son2 = dfs(root.right, p, q);
        // 最近祖先只有两种情况, 一种是左右子节点各含有一个, 一种是任意子节点含有一个根节点本身是另一个
        if ((son1 && son2) || ((root.val == p.val || root.val == q.val) && (son1 || son2))) {
            ans = root;
        }
        return son1 || son2 || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
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
