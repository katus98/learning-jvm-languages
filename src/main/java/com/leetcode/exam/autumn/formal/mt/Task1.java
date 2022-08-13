package com.leetcode.exam.autumn.formal.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int t = Integer.parseInt(items[1]);
        items = scanner.nextLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(items[i]);
        }
        scanner.close();
        Arrays.sort(array);
        int time = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (time + t <= array[i]) {
                time += t;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
