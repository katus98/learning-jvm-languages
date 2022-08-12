package com.leetcode.main.interval1.q25;

/**
 * k个一组翻转链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class Solution {
    /**
     * 使用k个链表数组, 先判断有几组需要反转, 每次反转一组, 记录最后的节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head), current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int num = count / k;
        ListNode[] pointers = new ListNode[k];
        ListNode lastTail = dummyHead;
        current = head;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < k; j++) {
                pointers[j] = current;
                current = current.next;
            }
            for (int j = k - 1; j >= 1; j--) {
                pointers[j].next = pointers[j - 1];
            }
            lastTail.next = pointers[k - 1];
            lastTail = pointers[0];
        }
        lastTail.next = current;
        return dummyHead.next;
    }

    /**
     * 常数个额外空间
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head), current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int num = count / k;
        ListNode lastTail = dummyHead, tempHead = head, tempTail;
        for (int i = 0; i < num; i++) {
            tempTail = tempHead;
            for (int j = 0; j < k - 1; j++) {
                tempTail = tempTail.next;
            }
            ListNode[] nodes = reverse(tempHead, tempTail);
            lastTail.next = nodes[0];
            lastTail = nodes[1];
            tempHead = lastTail.next;
        }
        return dummyHead.next;
    }

    /**
     * 反转链表: 前中后三个指针, 先记录后续的, 再将当前指针指向前, 然后向后移动一位
     */
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head, pre = tail.next, nex;
        while (pre != tail) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
