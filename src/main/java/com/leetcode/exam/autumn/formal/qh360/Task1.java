package com.leetcode.exam.autumn.formal.qh360;

import java.util.Arrays;
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
        int m = Integer.parseInt(items[1]);
        long[][] array = new long[n][];
        for (int i = 0; i < n; i++) {
            array[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        scanner.close();
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                array[i][j] += array[i - 1][j];
            }
        }
        long res = 0L, current;
        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            current = 0L;
            if (i >= 7) {
                for (int j = i - 6; j < i; j++) {
                    current += s[j];
                }
            } else {
                for (int j = 0; j < i; j++) {
                    current += s[j];
                }
            }
            long money;
            for (int j = 0; j < m; j++) {
                if (i >= 7) {
                    money = array[i][j] - array[i - 7][j];
                } else {
                    money = array[i][j];
                }
                if (current <= money) {
                    s[i] += money + 1 - current;
                    res += money + 1 - current;
                    current = money + 1;
                }
            }
        }
        System.out.println(res);
    }
}

