package com.leetcode.exam.autumn.pre.nio;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        Arrays.sort(array);
        int sum = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            if (sum + array[i] > x[1]) break;
            sum += array[i];
        }
        System.out.println(i);
    }
}
