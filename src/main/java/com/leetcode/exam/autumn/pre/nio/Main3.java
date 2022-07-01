package com.leetcode.exam.autumn.pre.nio;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-01
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        Deque<String> stack = new LinkedList<>();
        int last = 0;
        boolean isLeft = true;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            switch (ch) {
                case '/':
                    isLeft = false;
                    break;
                case '>':
                    String item = line.substring(last, i + 1);
                    if (isLeft) {
                        if (!checkLabel(item)) {
                            System.out.println("NO");
                            return;
                        }
                        stack.push(item);
                    } else {
                        if (stack.isEmpty()) {
                            System.out.println("NO");
                            return;
                        }
                        String left = stack.pop();
                        if (!match(left, item)) {
                            System.out.println("NO");
                            return;
                        }
                        isLeft = true;
                    }
                    last = i + 1;
            }
        }
        if (stack.isEmpty() && last == line.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean checkLabel(String label) {
        if (label.length() <= 2) return false;
        if (label.charAt(0) != '<' || label.charAt(label.length() - 1) != '>') return false;
        for (int i = 1; i < label.length() - 1; i++) {
            if (!Character.isLowerCase(label.charAt(i))) return false;
        }
        return true;
    }

    private static boolean match(String left, String right) {
        String s = "" + left.charAt(0) + "/" + left.substring(1);
        return s.equals(right);
    }
}
