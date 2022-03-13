package com.leetcode.offer.q28;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 */
public class Solution {
    /**
     * 迭代方法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeLast();
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                queue.addFirst(left.left);
                queue.addLast(right.right);
                queue.addFirst(left.right);
                queue.addLast(right.left);
            } else if (left != null || right != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归解法
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return check(left.left, right.right) && check(left.right, right.left);
        } else return left == null && right == null;
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
