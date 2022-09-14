package com.leetcode.exam.autumn.formal.xiaomi;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-14
 */
public class Task2 {
    private Node head, last;

    public Node Convert(Node pRootOfTree) {
        this.head = null;
        this.last = null;
        inorder(pRootOfTree);
        return head;
    }

    private void inorder(Node node) {
        if (node != null) {
            Node r = node.right;
            inorder(node.left);
            if (head == null) {
                head = node;
            } else {
                last.right = node;
                node.left = last;
            }
            last = node;
            inorder(r);
        }
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
