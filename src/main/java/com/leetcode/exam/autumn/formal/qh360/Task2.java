package com.leetcode.exam.autumn.formal.qh360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-27
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int res = array[3];
            if (array[0] <= array[2]) {
                res += array[0];
                res += array[1] / 2;
            } else {
                res += array[2];
                array[0] -= array[2];
                res += array[1] / 2;
                if (array[1] % 2 == 1 && array[0] >= 2) {
                    res += 1;
                    array[0] -= 2;
                }
                res += array[0] / 4;
            }
            System.out.println(res);
        }
        scanner.close();
    }
}
