package com.leetcode.exam.autumn.formal.ant.data;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-22
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            String[] items = scanner.nextLine().split(" ");
            int n = Integer.parseInt(items[0]);
            int m = Integer.parseInt(items[1]);
            int count = 0;
            if (n - 1 > 0) {
                if ((n - 1) % 2 == 1) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
            if (m - 1 > 0) {
                if ((m - 1) % 2 == 1) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}
