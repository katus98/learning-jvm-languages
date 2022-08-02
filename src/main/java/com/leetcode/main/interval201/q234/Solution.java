package com.leetcode.main.interval201.q234;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-06
 */
public class Solution {
    /**
     * 遍历链表将数值放入数组中, 然后首位双指针判断回文
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i++).compareTo(list.get(j--)) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 链表通过快慢指针分成前后两部分, 后部分反转, 然后依次比较元素
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode head2 = reserve(slow);
        ListNode cur1 = head, cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private ListNode reserve(ListNode head) {
        ListNode prev = null, cur = head, nex;
        while (cur != prev) {
            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
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
