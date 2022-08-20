package com.leetcode.exam.autumn.formal.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        int maxA = 0, maxB = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                maxA = Math.max(maxA, array[i]);
            } else {
                maxB = Math.max(maxB, array[i]);
            }
        }
        if (maxA == maxB) {
            maxB++;
        }
        if (n == 1) {
            System.out.println(0);
        } else {
            long count = 0L;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    count += maxA - array[i];
                } else {
                    count += maxB - array[i];
                }
            }
            System.out.println(count);
        }
    }
}
