package com.leetcode.main.q94;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-28
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        list.clear();
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
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
