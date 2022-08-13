package com.leetcode.exam.autumn.formal.mt;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] items = scanner.nextLine().split(" ");
        scanner.close();
        Deque<String> deque = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            deque.addFirst(items[i]);
            deque.addFirst(deque.removeLast());
            deque.addFirst(deque.removeLast());
        }
        System.out.print(deque.removeFirst());
        for (int i = 1; i < n; i++) {
            System.out.print(" " + deque.removeFirst());
        }
        System.out.println();
    }
}
