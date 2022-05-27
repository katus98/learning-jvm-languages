package com.leetcode.main.interval801.q876;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        int i = 0;
        ListNode current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        int index = i / 2 + 1;
        i = 0;
        current = head;
        while (current != null) {
            if (++i == index) {
                break;
            }
            current = current.next;
        }
        return current;
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
