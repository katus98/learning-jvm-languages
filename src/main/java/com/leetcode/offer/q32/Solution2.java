package com.leetcode.offer.q32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 */
public class Solution2 {

    /**
     * 每加入一个结点, 同时记录节点的层次
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Tuple<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Tuple<>(root, 1));
        while (!queue.isEmpty()) {
            Tuple<TreeNode, Integer> tuple = queue.remove();
            TreeNode node = tuple._1();
            Integer level = tuple._2();
            if (list.size() < level) {
                list.add(new ArrayList<>());
            }
            list.get(level - 1).add(node.val);
            if (node.left != null) {
                queue.add(new Tuple<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple<>(node.right, level + 1));
            }
        }
        return list;
    }

    /**
     * @see com.leetcode.base.Tuple
     */
    public static class Tuple<U, V> {
        private U _1;
        private V _2;

        public Tuple() {
        }

        public Tuple(U _1, V _2) {
            this._1 = _1;
            this._2 = _2;
        }

        public U _1() {
            return _1;
        }

        public void _1(U _1) {
            this._1 = _1;
        }

        public V _2() {
            return _2;
        }

        public void _2(V _2) {
            this._2 = _2;
        }
    }

    /**
     * 简洁, 每次都把这一层全部出队之后再进入下一次循环, 每一层的数量都等于第一次排出该层元素之前队列中元素的数量
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
