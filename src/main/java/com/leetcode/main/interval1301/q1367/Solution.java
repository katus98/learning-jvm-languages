package com.leetcode.main.interval1301.q1367;

/**
 * 二叉树中的列表
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-25
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        // 如果结点值相等 dfs扫描接下来联系的节点数值是否一一对应
        if (head.val == root.val && dfs(head, root)) {
            return true;
        }
        // 分别扫描左右节点
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) {
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
