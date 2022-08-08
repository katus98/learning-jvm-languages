package com.leetcode.main.interval101.q173;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树迭代器
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-08
 */
public class BSTIterator {
    private TreeNode node;
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.node = root;
        this.stack = new LinkedList<>();
    }

    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }

    public boolean hasNext() {
        return node != null || !stack.isEmpty();
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
