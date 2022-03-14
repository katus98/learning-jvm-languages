package com.leetcode.offer.q34;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    private int target;
    private List<List<Integer>> list;

    /**
     * 一份原创的简单DFS解法题目
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        this.list = new ArrayList<>();
        if (root != null) {
            dfs(root, 0, new LinkedList<>());
        }
        return list;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> route) {
        sum += root.val;
        route.push(root.val);
        if (root.left != null) {
            dfs(root.left, sum, route);
            route.pop();
        }
        if (root.right != null) {
            dfs(root.right, sum, route);
            route.pop();
        }
        if (root.left == null && root.right == null) {
            if (sum == target) {
                List<Integer> theRoute = new ArrayList<>();
                Iterator<Integer> iterator = route.descendingIterator();
                while (iterator.hasNext()) {
                    theRoute.add(iterator.next());
                }
                list.add(theRoute);
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
