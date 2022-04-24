package com.leetcode.main.q105;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-24
 */
public class Solution {
    /**
     * 递归
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (e1 - s1 > 0 && e2 - s2 > 0) {
            TreeNode node = new TreeNode(preorder[s1]);
            int index;
            for (index = s2; index < e2; index++) {
                if (inorder[index] == node.val) break;
            }
            int leftNum = index - s2, rightNum = e2 - index - 1;
            node.left = build(preorder, s1 + 1, s1 + 1 + leftNum, inorder, s2, index);
            node.right = build(preorder, s1 + 1 + leftNum, e1, inorder, index + 1, e2);
            return node;
        } else {
            return null;
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
