package com.leetcode.offer.q26;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 树的子结构
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.val == B.val) {
                if (checkPreOrder(node, B)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }
        }
        return false;
    }

    private boolean checkPreOrder(TreeNode a, TreeNode b) {
        if (b == null) {
            return false;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        if (b.left != null) {
            if (!checkPreOrder(a.left, b.left)) {
                return false;
            }
        }
        if (b.right != null) {
            return checkPreOrder(a.right, b.right);
        }
        return true;
    }

    /**
     * 简洁的写法, 两次递归实现遍历
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
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
