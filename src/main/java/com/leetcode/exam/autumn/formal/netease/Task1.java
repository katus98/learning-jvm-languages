package com.leetcode.exam.autumn.formal.netease;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        String aStr = String.valueOf(a), bStr = String.valueOf(b);
        if (aStr.contains("1") || bStr.contains("1")) {
            int size = Math.min(aStr.length(), bStr.length());
            if (size - 1 != 4) {
                System.out.println(size - 1);
            } else {
                System.out.println(4);
            }
        } else {
            System.out.println(-1);
        }
    }
}
