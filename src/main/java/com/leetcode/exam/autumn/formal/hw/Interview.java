package com.leetcode.exam.autumn.formal.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-20
 */
public class Interview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        Interview interview = new Interview();
        Node head = interview.decode(s);
        System.out.println(interview.findMiddleNode(head).val);
    }

    public Node decode(String s) {
        int[] array = Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Node dummyHead = new Node(-1), before = dummyHead;
        for (int num : array) {
            before.next = new Node(num);
            before = before.next;
        }
        return dummyHead.next;
    }

    public Node findMiddleNode(Node head) {
        Node dummyHead = new Node(-1, head);
        Node slow = dummyHead, fast = dummyHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }


    public static class Node {
        int val;
        Node next;

        public Node() {
            this(-1, null);
        }

        public Node(int val) {
            this(val, null);
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
