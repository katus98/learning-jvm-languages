package com.leetcode.exam.autumn.formal.jd;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-27
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int k = Integer.parseInt(items[1]);
        String str = scanner.nextLine();
        scanner.close();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                builder.append(Character.toUpperCase(ch));
            } else {
                builder.append(ch);
            }
        }
        for (int i = k; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                builder.append(Character.toLowerCase(ch));
            } else {
                builder.append(ch);
            }
        }
        System.out.println(builder);
    }
}
