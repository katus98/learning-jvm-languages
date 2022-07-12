package com.leetcode.main.interval101.q145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        this.list.clear();
        postorder(root);
        return list;
    }

    /**
     * 递归实现
     */
    private void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            list.add(root.val);
        }
    }

    /**
     * 迭代实现
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        this.list.clear();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                // 如果右节点不存在或者已经遍历过了
                list.add(node.val);
                prev = node;
                node = null;
            } else {
                // 如果右节点没有遍历过
                stack.push(node);
                node = node.right;
            }
        }
        return list;
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
