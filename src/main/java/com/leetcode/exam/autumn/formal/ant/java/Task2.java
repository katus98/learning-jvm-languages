package com.leetcode.exam.autumn.formal.ant.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-10-27
 */
public class Task2 {
    private static final Map<Character, Integer> INDEX_MAP = new HashMap<>();
    private static final int[] TOP = new int[5], DOWN = new int[5], LEFT = new int[5], RIGHT = new int[5];

    static {
        INDEX_MAP.put('W', 0);
        INDEX_MAP.put('D', 1);
        INDEX_MAP.put('S', 2);
        INDEX_MAP.put('A', 3);
        INDEX_MAP.put('*', 4);
        TOP[0] = 1;
        TOP[1] = 1;
        TOP[3] = 1;
        DOWN[1] = 1;
        DOWN[2] = 1;
        DOWN[3] = 1;
        LEFT[0] = 1;
        LEFT[2] = 1;
        LEFT[3] = 1;
        RIGHT[0] = 1;
        RIGHT[1] = 1;
        RIGHT[2] = 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            String[] items = scanner.nextLine().split(" ");
            int n = Integer.parseInt(items[0]);
            int m = Integer.parseInt(items[1]);
            boolean res = true;
            String lastLine = scanner.nextLine();
            if (!checkRow(lastLine)) {
                res = false;
            }
            for (int j = 1; j < n; j++) {
                String line = scanner.nextLine();
                if (res) {
                    if (!checkRow(line)) {
                        res = false;
                    }
                }
                if (res) {
                    if (!checkCol(lastLine, line)) {
                        res = false;
                    }
                }
                lastLine = line;
            }
            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }

    private static boolean checkRow(String line) {
        char lastCh = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch != '*' && lastCh != '*') {
                int lastI = INDEX_MAP.get(lastCh);
                int theI = INDEX_MAP.get(ch);
                if ((RIGHT[lastI] ^ LEFT[theI]) == 0) {
                    return false;
                }
            }
            lastCh = ch;
        }
        return true;
    }

    private static boolean checkCol(String lastLine, String line) {
        for (int i = 0; i < line.length(); i++) {
            char upCh = lastLine.charAt(i);
            char ch = line.charAt(i);
            if (ch != '*' && upCh != '*') {
                int upI = INDEX_MAP.get(upCh);
                int theI = INDEX_MAP.get(ch);
                if ((DOWN[upI] ^ TOP[theI]) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
