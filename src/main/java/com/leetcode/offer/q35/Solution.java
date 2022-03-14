package com.leetcode.offer.q35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    private final Map<Node, Integer> indexMap = new HashMap<>();
    private final Map<Integer, Node> newIndexMap = new HashMap<>();
    private Integer[] randomArray;

    /**
     * 原创, 通过记住索引关系来保存随机指针的指向 (略麻烦)
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 初始化新的链表, 生成新旧节点索引查找表
        Node current = head, newHead = new Node(head.val), newCurrent = newHead;
        int i = 0;
        indexMap.put(current, i);
        newIndexMap.put(i++, newCurrent);
        while (current.next != null) {
            newCurrent.next = new Node(current.next.val);
            current = current.next;
            newCurrent = newCurrent.next;
            indexMap.put(current, i);
            newIndexMap.put(i++, newCurrent);
        }
        this.randomArray = new Integer[i];
        // 构建随机指针查找表
        current = head;
        i = 0;
        while (current != null) {
            if (current.random != null) {
                randomArray[i++] = indexMap.get(current.random);
            } else {
                randomArray[i++] = null;
            }
            current = current.next;
        }
        newCurrent = newHead;
        i = 0;
        while (newCurrent != null) {
            if (randomArray[i] != null) {
                newCurrent.random = newIndexMap.get(randomArray[i]);
            }
            i++;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }

    private Map<Node, Node> map = new HashMap<>();

    /**
     * 记录原始节点和新创建节点的映射关系
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node newHead;
        if (!map.containsKey(head)) {
            newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList2(head.next);
            newHead.random = copyRandomList2(head.random);
        } else {
            newHead = map.get(head);
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
