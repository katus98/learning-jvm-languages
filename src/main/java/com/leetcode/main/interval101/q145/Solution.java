package com.leetcode.main.interval101.q145;

import java.util.ArrayList;
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

    private void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            list.add(root.val);
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
