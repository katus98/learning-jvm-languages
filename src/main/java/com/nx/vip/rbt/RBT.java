package com.nx.vip.rbt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 左倾红黑树
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
public class RBT<E extends Comparable<E>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Node root;
    private int size;

    /**
     * 返回含有的元素数量
     *
     * @return 数量
     */
    public int size() {
        return size;
    }

    /**
     * 将e元素添加到红黑树中
     *
     * @param e 新添加的元素
     */
    public void addEle(E e) {
        root = addEle(root, e);
        root.color = BLACK;
    }

    /**
     * 层次遍历树
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            System.out.println(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    /**
     * 将元素e添加到以node为根的那个树上并且将新树的根返回
     *
     * @param node 子树根节点
     * @param e    新元素
     * @return 新树根
     */
    private Node addEle(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addEle(node.left, e);
        } else {
            node.right = addEle(node.right, e);
        }
        // 左旋: node.right 红 && node.left 非红 (为了保证是一个左倾红黑树)
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        // 右旋: 节点的左侧和左侧的左侧都是红色的 (保持平衡)
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        // 颜色翻转: 如果节点的左右两侧都是红色的
        if (isRed(node.right) && isRed(node.left)) {
            flipColors(node);
        }
        return node;
    }

    /**
     * node                     x
     * /   \     左旋转         /  \
     * T1   x   --------->   node   T3
     * / \              /   \
     * T2 T3            T1   T2
     *
     * @param node 根节点
     * @return 左旋后的根节点
     */
    private Node leftRotate(Node node) {
        Node x = node.right;

        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * node                   x
     * /   \     右旋转       /  \
     * x    T2   ------->   y   node
     * / \                       /  \
     * y  T1                     T1  T2
     *
     * @param node 根节点
     * @return 右旋后的根节点
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 颜色反转
     *
     * @param node 颜色反转的根节点
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 判断节点是否为红色节点
     *
     * @param node 节点
     * @return 是否为红色
     */
    private boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color;
    }

    /**
     * 节点
     */
    private class Node {
        public E e;
        public Node left;
        public Node right;
        public boolean color;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.color = RED;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", color=" + (color ? "RED" : "BLACK") +
                    '}';
        }
    }
}
