package com.leetcode.exam.autumn.formal.ant.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-10-27
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        long n = Long.parseLong(items[0]);
        long k = Long.parseLong(items[1]);
        long[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        scanner.close();
        long res = 0;
        for (int i = 0; i < array.length; i++) {
            res += (array[i] - 1) / k;
        }
        System.out.println(res);
    }
}
