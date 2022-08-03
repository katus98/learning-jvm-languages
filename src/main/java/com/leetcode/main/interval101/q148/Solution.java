package com.leetcode.main.interval101.q148;

/**
 * 排序链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-20
 */
public class Solution {
    /**
     * 插入法: 从前向后链表, 每遍历一个头节点就将他拆下来插入到排序的链表中, 但是会超时
     */
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode cur = head, nex, front, temp;
        while (cur != null) {
            nex = cur.next;
            front = dummyHead;
            while (front.next != null) {
                if (front.next.val >= cur.val) {
                    temp = front.next;
                    front.next = cur;
                    cur.next = temp;
                    break;
                }
                front = front.next;
            }
            // 对于放在最后的节点需要格外处理
            if (front.next == null) {
                front.next = cur;
                cur.next = null;
            }
            cur = nex;
        }
        return dummyHead.next;
    }

    /**
     * 归并法: 注意当拆分成单节点之后要注意把节点的next设置为null
     */
    public ListNode sortList2(ListNode head) {
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) return null;
        // 快慢指针确定链表中点
        if (head.next != tail) {
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode list1 = mergeSort(head, slow);
            ListNode list2 = mergeSort(slow, tail);
            return mergeList(list1, list2);
        } else {
            // 切记需要断开链表
            head.next = null;
            return head;
        }
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1, null), front = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                front.next = list1;
                list1 = list1.next;
            } else {
                front.next = list2;
                list2 = list2.next;
            }
            front = front.next;
        }
        if (list1 != null) {
            front.next = list1;
        }
        if (list2 != null) {
            front.next = list2;
        }
        return dummyHead.next;
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
