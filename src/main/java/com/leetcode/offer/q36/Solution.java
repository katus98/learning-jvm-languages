package com.leetcode.offer.q36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 */
public class Solution {
    private final List<Node> list = new ArrayList<>();

    /**
     * 搜索二叉树的中序遍历是递增序列
     */
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            node.left = list.get(i - 1 < 0 ? list.size() - 1 : i - 1);
            node.right = list.get(i + 1 >= list.size() ? 0 : i + 1);
        }
        return list.isEmpty() ? null : list.get(0);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root);
            inOrder(root.right);
        }
    }

    private Node pre, head;

    /**
     * 实际上不需要借助数组来存放node
     */
    public Node treeToDoublyList2(Node root) {
        if (root == null) return null;
        inOrder2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder2(Node root) {
        if (root != null) {
            inOrder2(root.left);
            if (pre != null) {
                pre.right = root;
            } else {
                head = root;
            }
            root.left = pre;
            pre = root;
            inOrder2(root.right);
        }
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
