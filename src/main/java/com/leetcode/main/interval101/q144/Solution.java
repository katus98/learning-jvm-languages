package com.leetcode.main.interval101.q144;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-06
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        list.clear();
        preorder(root);
        return list;
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left);
            preorder(root.right);
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
