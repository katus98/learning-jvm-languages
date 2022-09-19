package com.leetcode.main.interval1.q98;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-25
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        list.clear();
        inorder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) >= 0) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    private long lastValue;
    private boolean res;

    public boolean isValidBST2(TreeNode root) {
        this.lastValue = Long.MIN_VALUE;
        this.res = true;
        inorder2(root);
        return res;
    }

    private void inorder2(TreeNode root) {
        if (!res) return;
        if (root != null) {
            inorder2(root.left);
            if (root.val <= lastValue) {
                res = false;
                return;
            }
            this.lastValue = root.val;
            inorder2(root.right);
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
