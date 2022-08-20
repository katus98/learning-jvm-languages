package com.leetcode.exam.autumn.formal.netease;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        scanner.close();
        long count;
        if (words.length() % 2 == 1) {
            StringBuilder builder1 = new StringBuilder(), builder2 = new StringBuilder();
            for (int i = 0; i < words.length() / 4 + 1; i++) {
                builder1.append("rede");
                builder2.append("dere");
            }
            String w1 = builder1.toString(), w2 = builder2.toString();
            long count1 = 0L, count2 = 0L;
            for (int i = 0; i < words.length(); i++) {
                if (w1.charAt(i) != words.charAt(i)) count1++;
                if (w2.charAt(i) != words.charAt(i)) count2++;
            }
            count = Math.min(count1, count2);
        } else {
            int c = 0;
            for (int i = 0; i < words.length(); i++) {
                if (words.charAt(i) == 'e') {
                    c++;
                }
            }
            if (c == (words.length() - 1) / 2) {
                count = 0L;
            } else {
                count = Math.abs((words.length() - 1) / 2 - c);
            }
        }
        System.out.println(count);
    }
}
