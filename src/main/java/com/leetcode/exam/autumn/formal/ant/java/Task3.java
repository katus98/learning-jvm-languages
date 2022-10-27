package com.leetcode.exam.autumn.formal.ant.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-10-27
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int k = Integer.parseInt(items[1]);
        String line = scanner.nextLine();
        scanner.close();
        long res = n;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (line.charAt(j) == line.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                if (dp[i][j] < k) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int k = Integer.parseInt(items[1]);
        String line = scanner.nextLine();
        scanner.close();
        long res = n;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp, 0);
            for (int j = i + 1; j < n; j++) {
                if (line.charAt(j) == line.charAt(j - 1)) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = dp[j - 1] + 1;
                }
                if (dp[j] < k) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
