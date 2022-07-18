package com.leetcode.main.interval501.q589;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-19
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        this.list.clear();
        preorderIn(root);
        return list;
    }

    private void preorderIn(Node root) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    preorderIn(child);
                }
            }
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
