package com.leetcode.main.q138;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-19
 * @see com.leetcode.offer.q35.Solution
 */
public class Solution {
    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        this.map.clear();
        return copy(head);
    }

    /**
     * 设置旧节点到新节点的映射
     * 递归复制, 如果新节点已经存在就从映射中取出新节点
     * 如果不存在则拷贝, 递归调用next和random
     */
    private Node copy(Node head) {
        if (head == null) return null;
        Node newHead;
        if (map.containsKey(head)) {
            newHead = map.get(head);
        } else {
            newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copy(head.next);
            newHead.random = copy(head.random);
        }
        return newHead;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
