package com.leetcode.exam.autumn.formal.mhy;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chs = scanner.nextLine().toCharArray();
        scanner.close();
        int count = 0;
        for (int i = 0; i < chs.length - 4; i++) {
            if (check(chs, i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(char[] chs, int i) {
        return chs[i] == '<' && chs[i + 1] == 'd' && chs[i + 2] == 'i' && chs[i + 3] == 'v' && chs[i + 4] == '>';
    }
}
