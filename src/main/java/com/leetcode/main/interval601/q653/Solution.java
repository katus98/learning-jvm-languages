package com.leetcode.main.interval601.q653;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和 IV - 输入 BST
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-16
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历 + 双指针
     */
    public boolean findTarget(TreeNode root, int k) {
        this.list.clear();
        inorder(root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int num = list.get(i) + list.get(j);
            if (num > k) {
                j--;
            } else if (num < k) {
                i++;
            } else {
                break;
            }
        }
        return i < j && list.get(i) + list.get(j) == k;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
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
