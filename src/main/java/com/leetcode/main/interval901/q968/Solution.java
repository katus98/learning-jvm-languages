package com.leetcode.main.interval901.q968;

/**
 * 监控二叉树
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-26
 */
public class Solution {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        // 状态 a：root 必须放置摄像头的情况下, 覆盖整棵树需要的摄像头数目
        // 状态 b：覆盖整棵树需要的摄像头数目, 无论 root 是否放置摄像头
        // 状态 c：覆盖两棵子树需要的摄像头数目, 无论节点 root 本身是否被监控到
        // a = lc + rc + 1
        // b = min(a, min(la + rb, ra + lb))
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
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
