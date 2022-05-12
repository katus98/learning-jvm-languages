package com.leetcode.exam.summer.hw;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-11
 */
public class Main2 {
    private static int black = 0, white = 0;
    private static final HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        int n, k = 0;
        char[] chs;
        if (Character.isDigit(input.charAt(1))) {
            n = Integer.parseInt(input.substring(0, 2));
            chs = input.substring(2).toCharArray();
        } else {
            n = Integer.parseInt(input.substring(0, 1));
            chs = input.substring(1).toCharArray();
        }
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = chs[k++];
            }
        }
        black = 0;
        white = 0;
        toBW(chess, n);
        System.out.printf("B %d W %d", black, white);
    }

    private static void toBW(char[][] chess, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chess[i][j] == 'B') {
                    set.clear();
                    int count = dfs(chess, n, i, j, 'B');
                    if (set.size() >= 2) {
                        black += count;
                    }
                } else if (chess[i][j] == 'W') {
                    set.clear();
                    int count = dfs(chess, n, i, j, 'W');
                    if (set.size() >= 2) {
                        white += count;
                    }
                }
            }
        }
    }

    private static int dfs(char[][] chess, int n, int i, int j, char color) {
        int count = 0;
        if (chess[i][j] == color) {
            chess[i][j] = 'X';
            count++;
            if (isValid(i - 1, j, n)) {
                count += dfs(chess, n, i - 1, j, color);
            }
            if (isValid(i + 1, j, n)) {
                count += dfs(chess, n, i + 1, j, color);
            }
            if (isValid(i, j - 1, n)) {
                count += dfs(chess, n, i, j - 1, color);
            }
            if (isValid(i, j + 1, n)) {
                count += dfs(chess, n, i, j + 1, color);
            }
        } else if (chess[i][j] == 'N') {
            set.add(i + "-" + j);
        }
        return count;
    }

    private static boolean isValid(int i, int j, int n) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
