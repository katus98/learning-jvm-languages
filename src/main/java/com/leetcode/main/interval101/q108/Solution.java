package com.leetcode.main.interval101.q108;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-08
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int i, int j) {
        if (i <= j) {
            int cur = i + ((j - i) >> 1);
            TreeNode node = new TreeNode(nums[cur]);
            node.left = build(nums, i, cur - 1);
            node.right = build(nums, cur + 1, j);
            return node;
        }
        return null;
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
