package com.leetcode.main.interval101.q113;

import java.util.*;

/**
 * 路径总和 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 * @see com.leetcode.offer.q34.Solution
 */
public class Solution {
    private int target;
    private List<List<Integer>> list;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.list = new ArrayList<>();
        if (root != null) {
            dfs(root, 0, new LinkedList<>());
        }
        return list;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> route) {
        sum += root.val;
        route.addLast(root.val);
        if (root.left != null) {
            dfs(root.left, sum, route);
            route.removeLast();
        }
        if (root.right != null) {
            dfs(root.right, sum, route);
            route.removeLast();
        }
        if (root.left == null && root.right == null) {
            if (sum == target) {
                list.add(new ArrayList<>(route));
            }
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
