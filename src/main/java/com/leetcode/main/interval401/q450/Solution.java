package com.leetcode.main.interval401.q450;

/**
 * 删除二叉搜索树中的节点
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-09
 */
public class Solution {
    /**
     * 递归法
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 如果为null, 返回null
        if (root == null) return null;
        // 如果大 删除右侧
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // 如果小 删除左侧
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        // 如果要删除的就是自己
        // 如果左右子节点都是null
        if (root.left == null && root.right == null) {
            // 删除本身
            return null;
        }
        // 如果只有左侧有
        if (root.left != null && root.right == null) {
            // 删除本身, 左侧提上来
            return root.left;
        }
        // 如果只有右侧有
        if (root.left == null) {
            // 删除本身 右侧提上来
            return root.right;
        }
        // 找到右侧中最小的节点
        TreeNode node = root.right;
        while (node.left != null) {
            node = node.left;
        }
        // 删除这个节点
        root.right = deleteNode(root.right, node.val);
        // 将这个节点放在root的位置
        node.left = root.left;
        node.right = root.right;
        return node;
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
