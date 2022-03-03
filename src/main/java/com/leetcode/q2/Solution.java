package com.leetcode.q2;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode();
        ListNode current = list;
        Boolean flag = false;
        while (true) {
            if (l1 != null) {
                current.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current.val += l2.val;
                l2 = l2.next;
            }
            if (flag) {
                current.val += 1;
                flag = false;
            }
            if (current.val >= 10) {
                current.val -= 10;
                flag = true;
            }
            if (l1 != null || l2 != null || flag) {
                current.next = new ListNode();
                current = current.next;
            } else {
                break;
            }
        }
        return list;
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
