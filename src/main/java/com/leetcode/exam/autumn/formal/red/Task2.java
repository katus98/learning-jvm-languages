package com.leetcode.exam.autumn.formal.red;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-28
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        long k = Long.parseLong(items[1]);
        long[] mags = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        scanner.close();
        Arrays.sort(mags);
        long count = 0L;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (mags[i] * mags[j] >= k) {
                    count += (n - j) * 2L;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
