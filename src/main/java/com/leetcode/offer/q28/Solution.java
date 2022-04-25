package com.leetcode.offer.q28;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 */
public class Solution {
    /**
     * 迭代方法
     * 双向队列, 从首尾加入对称元素
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        // 根节点的左右子节点从首尾加入队列
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
            // 分别从头尾拿出一对节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeLast();
            // 检查这一对节点是否对称
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                // 如果对称则将子节点对称放入首尾
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

    /**
     * 检查左侧和右侧对称节点是否对称
     */
    private boolean check(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            // 检查当前一对节点的子节点是否对称(两对)
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
