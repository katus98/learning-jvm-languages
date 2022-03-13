package com.leetcode.offer.q27;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 */
public class Solution {
    /**
     * 迭代解法
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                queue.push(node.right);
            }
            if (node.left != null) {
                queue.push(node.left);
            }
        }
        return root;
    }

    /**
     * 递归解法
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree2(root.left);
        TreeNode right = mirrorTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
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
