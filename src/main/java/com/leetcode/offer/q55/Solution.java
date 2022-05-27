package com.leetcode.offer.q55;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 * @see com.leetcode.main.interval101.q104.Solution
 */
public class Solution {
    private int maxD;

    public int maxDepth(TreeNode root) {
        this.maxD = 0;
        dfs(root, maxD);
        return maxD;
    }

    private void dfs(TreeNode node, int depth) {
        if (node != null) {
            depth++;
            this.maxD = Math.max(depth, maxD);
            dfs(node.left, depth);
            dfs(node.right, depth);
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
