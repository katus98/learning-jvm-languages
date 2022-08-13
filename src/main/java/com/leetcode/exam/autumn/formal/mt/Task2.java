package com.leetcode.exam.autumn.formal.mt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Task2 {
    private static final Map<Character, int[]> DIR_MAP = new HashMap<>();

    static {
        DIR_MAP.put('W', new int[]{-1, 0});
        DIR_MAP.put('S', new int[]{1, 0});
        DIR_MAP.put('A', new int[]{0, -1});
        DIR_MAP.put('D', new int[]{0, 1});
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int m = Integer.parseInt(items[1]);
        int k = Integer.parseInt(items[2]);
        String orders = scanner.nextLine();
        scanner.close();
        if (k + 1 < m * n) {
            System.out.println("No");
        } else {
            int count = 1;
            int i = 0, j = 0;
            boolean[][] visited = new boolean[n][m];
            visited[i][j] = true;
            for (int l = 0; l < k; l++) {
                char order = orders.charAt(l);
                int[] dir = DIR_MAP.get(order);
                i += dir[0];
                j += dir[1];
                if (!visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    if (count == m * n) {
                        System.out.println("Yes");
                        System.out.println(l + 1);
                        break;
                    }
                }
            }
            if (count < m * n) {
                System.out.println("No");
                System.out.println(m * n - count);
            }
        }
    }
}
