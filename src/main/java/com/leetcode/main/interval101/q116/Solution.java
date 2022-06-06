package com.leetcode.main.interval101.q116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-06
 */
public class Solution {
    /**
     * 层序遍历, 每次遍历一层
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node front = queue.remove();
            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
            for (int i = size - 1; i > 0; i--) {
                Node nex = queue.remove();
                if (nex.left != null) queue.add(nex.left);
                if (nex.right != null) queue.add(nex.right);
                front.next = nex;
                front = nex;
            }
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
