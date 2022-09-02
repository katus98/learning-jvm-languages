package com.leetcode.exam.autumn.formal.oppo;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-02
 */
public class Task2 {
    public ListNode combineTwoDisorderNodeToOrder(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode dummyHead = new ListNode(-1), before = dummyHead;
        dummyHead.next = node1;
        while (before.next != null) {
            before = before.next;
        }
        before.next = node2;
        return sort(dummyHead.next, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        } else {
            ListNode fast = head, slow = head;
            while (fast != tail) {
                fast = fast.next;
                slow = slow.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode list1 = sort(head, slow);
            ListNode list2 = sort(slow, tail);
            return merge(list1, list2);
        }
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1), before = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                before.next = list1;
                list1 = list1.next;
            } else {
                before.next = list2;
                list2 = list2.next;
            }
            before = before.next;
        }
        if (list1 != null) {
            before.next = list1;
        }
        if (list2 != null) {
            before.next = list2;
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
