package com.leetcode.main.interval601.q662;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-04
 */
public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        // 记录下每个节点的深度和序号
        queue.add(new AnnotatedNode(root, 0, 0));
        int maxWidth = 0, depth = 0, left = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode node = queue.remove();
            if (node.node != null) {
                queue.add(new AnnotatedNode(node.node.left, node.depth + 1, node.pos * 2));
                queue.add(new AnnotatedNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
                // 新的深度记录最左侧的非空序号
                if (depth != node.depth) {
                    depth = node.depth;
                    left = node.pos;
                }
                // 记录当前非空节点和当前行最左侧的非空序号之间的差的最大值
                maxWidth = Math.max(maxWidth, node.pos - left + 1);
            }
        }
        return maxWidth;
    }

    public static class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
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
