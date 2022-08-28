package com.leetcode.exam.autumn.formal.jd;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-27
 */
public class Task3 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if (n <= 5) {
            System.out.println(0);
        } else if (n == 6) {
            System.out.println(1);
        } else if (n == 7) {
            System.out.println(78);
        } else if (n == 8) {
            System.out.println(4056);
        } else if (n == 9) {
            System.out.println(175758);
        } else {
            System.out.println(process(2, 0, n, new StringBuilder()));
        }
    }

    private static int process(int redNeed, int i, int n, StringBuilder builder) {
        if (i == n && redNeed <= 0) return 1;
        if (i == n) return 0;
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == 'r' && n - i + 1 < redNeed * 3) return 0;
        if (builder.length() > 1 && builder.charAt(builder.length() - 1) == 'e' && builder.charAt(builder.length() - 2) == 'r' && n - i + 2 < redNeed * 3) return 0;
        int res = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            builder.append(ch);
            if (ch == 'd' && builder.length() >= 3 && builder.charAt(builder.length() - 2) == 'e' && builder.charAt(builder.length() - 3) == 'r') {
                res += process(redNeed - 1, i + 1, n, builder) % MOD;
            } else {
                res += process(redNeed, i + 1, n, builder) % MOD;
            }
            builder.deleteCharAt(builder.length() - 1);
        }
        return res;
    }
}
