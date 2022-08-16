package com.leetcode.exam.autumn.formal.lenovo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-16
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        String[] aliceItems = scanner.nextLine().split(" ");
        String[] bobItems = scanner.nextLine().split(" ");
        scanner.close();
        Map<String, Integer> map = new HashMap<>();
        map.put("Rock", 0);
        map.put("Paper", 1);
        map.put("Scissor", 2);
        int a = 0, b = 0;
        for (int i = 0; i < times; i++) {
            int al = map.get(aliceItems[i]);
            int bo = map.get(bobItems[i]);
            if (al - bo == 1 || (al == 0 && bo == 2)) {
                a++;
            } else if (bo - al == 1 || (bo == 0 && al == 2)) {
                b++;
            }
        }
        System.out.println(a + " " + b);
    }
}
