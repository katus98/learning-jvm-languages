package com.leetcode.offer.q22;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int sum = 0;
        ListNode current = head;
        while (current != null) {
            sum++;
            current = current.next;
        }
        current = head;
        int index = sum - k;
        while (index-- != 0) {
            current = current.next;
        }
        return current;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        int k1 = k;
        ListNode fast = head, slow = head;
        while (k1-- != 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
