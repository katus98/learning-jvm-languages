package com.leetcode.exam.autumn.formal.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-13
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        long mpCost = 0;
        for (int i = n - 1; i >= 2; i--) {
            int n1 = array[i - 2];
            int n2 = array[i - 1];
            int n3 = array[i];
            int f = Math.min(n1, Math.min(n2 / 2, n3 / 3));
            mpCost += 5L * f;
            array[i - 2] -= f;
            array[i - 1] -= 2 * f;
            array[i] -= 3 * f;
        }
        for (int i : array) {
            mpCost += i;
        }
        System.out.println(mpCost);
    }
}
