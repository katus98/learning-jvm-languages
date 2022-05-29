package com.leetcode.main.interval901.q958;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性检验
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    /**
     * 层序遍历: 如果放入队列之前，发现子节点为null，则之后的队列中的节点的子节点都必须为null，即只要发现子节点不为空即返回false
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                if (flag) return false;
                queue.add(node.left);
            } else {
                flag = true;
            }
            if (node.right != null) {
                if (flag) return false;
                queue.add(node.right);
            } else {
                flag = true;
            }
        }
        return true;
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
