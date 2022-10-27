package com.leetcode.exam.autumn.formal.ant.data;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-22
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        System.out.println(process2(line));
    }

    private static long process2(String line) {
        int wholeLength = line.length();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        for (int i = 0; i < wholeLength; i++) {
            int j = i + 1;
            if (!valid(j, wholeLength)) continue;
            if (line.charAt(i) == line.charAt(j)) {
                map2.put(i, j);
            }
            j = i + 2;
            if (!valid(j, wholeLength)) continue;
            if (line.charAt(i) == line.charAt(j)) {
                map3.put(i, j);
            }
        }
        long count = wholeLength;
        int i = 0;
        while (i < wholeLength) {
            if (map2.containsKey(i)) {
                i += 1;
                continue;
            }
            if (map3.containsKey(i)) {
                count += 2;
                i += 2;
                continue;
            }
            int start = i;
            while (i < wholeLength && !map2.containsKey(i) && !map3.containsKey(i)) {
                i++;
            }
            if (i == wholeLength) {
                i -= 1;
                int c = i - start + 1;
                int cc2 = c  * (c + 1) / 2 - c;
                count += cc2;
                break;
            }
            int c = i - start + 1;
            int cc2 = c  * (c + 1) / 2 - c;
            count += cc2;
            i++;
        }
        return count;
    }

    private static boolean valid(int i, int wholeLength) {
        return i >= 0 && i < wholeLength;
    }
}
