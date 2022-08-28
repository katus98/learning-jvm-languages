package com.leetcode.exam.autumn.formal.red;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-28
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int m = Integer.parseInt(items[1]);
        int i = Integer.parseInt(items[2]) - 1;
        int[] imps = new int[n];
        for (int j = 0; j < n; j++) {
            imps[j] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).reduce(Integer::sum).getAsInt();
        }
        scanner.close();
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (j <= i) {
                if (imps[j] >= imps[i]) {
                    count++;
                }
            } else {
                if (imps[j] > imps[i]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
