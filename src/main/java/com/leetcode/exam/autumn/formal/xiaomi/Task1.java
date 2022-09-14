package com.leetcode.exam.autumn.formal.xiaomi;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-14
 */
public class Task1 {
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        if (left == right) return head;
        ListNode<Integer> dummyHead = new ListNode<>(-1, head), before = dummyHead;
        right -= left;
        right++;
        while (left > 1) {
            before = before.next;
            left--;
        }
        reverse(before, right);
        return dummyHead.next;
    }

    private void reverse(ListNode<Integer> before, int count) {
        ListNode<Integer> pre = null, cur = before.next, nex;
        while (count >= 1) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
            count--;
        }
        ListNode<Integer> realHead = before.next;
        before.next = pre;
        realHead.next = cur;
    }

    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this(data, null);
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
