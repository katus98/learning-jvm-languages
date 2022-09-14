package com.leetcode.exam.autumn.formal.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-13
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        Set<Character> set = new HashSet<>(), s2 = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for (int i = 0; i < line.length() - 4; i++) {
            s2.clear();
            char ch1 = line.charAt(i);
            char ch2 = line.charAt(i + 1);
            char ch3 = line.charAt(i + 2);
            char ch4 = line.charAt(i + 3);
            char ch5 = line.charAt(i + 4);
            s2.add(ch1);
            s2.add(ch2);
            s2.add(ch3);
            s2.add(ch4);
            s2.add(ch5);
            if (s2.size() == 5 && set.contains(ch2) && set.contains(ch3) && set.contains(ch5) && !set.contains(ch1) && !set.contains(ch4)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
