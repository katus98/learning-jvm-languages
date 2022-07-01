package com.leetcode.exam.autumn.pre.nio;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        scanner.close();
        int[] array = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int m = array[0];
        for (int i = 1; i < array.length; i++) {
            if (m < array[i]) m = array[i];
        }
        System.out.println(m);
    }
}
