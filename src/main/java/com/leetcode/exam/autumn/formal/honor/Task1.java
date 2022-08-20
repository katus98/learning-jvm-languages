package com.leetcode.exam.autumn.formal.honor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        int i;
        int minCount = Integer.MAX_VALUE, count;
        for (int len = 1; len < array.length / 2; len++) {
            i = len;
            count = 1;
            while (i < array.length - 1) {
                i += array[i];
                count++;
            }
            if (i == array.length - 1) {
                minCount = Math.min(minCount, count);
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }
    }

    private static void m2(int[] array) {
        int[] dp = new int[array.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (dp[i] != -1) {
                for (int j = 1; j <= array[i] && i + j < array.length; j++) {
                    if (dp[i + j] == -1) {
                        dp[i + j] = dp[i] + 1;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
