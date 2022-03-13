package com.leetcode.main.q101;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 * @see com.leetcode.offer.q28.Solution
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
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
