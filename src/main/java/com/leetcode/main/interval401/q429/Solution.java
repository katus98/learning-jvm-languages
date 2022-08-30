package com.leetcode.main.interval401.q429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树的层序遍历
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-30
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            resList.add(list);
        }
        return resList;
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
