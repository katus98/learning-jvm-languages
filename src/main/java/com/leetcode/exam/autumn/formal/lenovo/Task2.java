package com.leetcode.exam.autumn.formal.lenovo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-16
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> aliceMap = new HashMap<>(), bobMap = new HashMap<>();
        boolean a, b;
        int[] aArr = new int[3], bArr = new int[3];
        for (int i = 0; i < times; i++) {
            a = false;
            b = false;
            String[] items = scanner.nextLine().split(" ");
            aliceMap.clear();
            for (int j = 0; j < 3; j++) {
                char ch = items[j].toCharArray()[0];
                int num = ch == 'A' ? 8 : ch - '0';
                aliceMap.put(num, aliceMap.getOrDefault(num, 0) + 1);
            }
            bobMap.clear();
            for (int j = 3; j < 6; j++) {
                char ch = items[j].toCharArray()[0];
                int num = ch == 'A' ? 8 : ch - '0';
                bobMap.put(num, bobMap.getOrDefault(num, 0) + 1);
            }
            if (aliceMap.size() < bobMap.size()) {
                a = true;
            } else if (aliceMap.size() > bobMap.size()) {
                b = true;
            } else {
                Arrays.fill(aArr, 0);
                Arrays.fill(bArr, 0);
                int size = aliceMap.size();
                if (size == 1) {
                    for (int num : aliceMap.keySet()) {
                        aArr[0] = num;
                    }
                    for (int num : bobMap.keySet()) {
                        bArr[0] = num;
                    }
                } else if (size == 2) {
                    for (int num : aliceMap.keySet()) {
                        if (aliceMap.get(num) == 2) {
                            aArr[0] = num;
                        } else {
                            aArr[1] = num;
                        }
                    }
                    for (int num : bobMap.keySet()) {
                        if (bobMap.get(num) == 2) {
                            bArr[0] = num;
                        } else {
                            bArr[1] = num;
                        }
                    }
                } else {
                    int x = 0;
                    for (int num : aliceMap.keySet()) {
                        aArr[x++] = num;
                    }
                    Arrays.sort(aArr);
                    x = aArr[0];
                    aArr[0] = aArr[2];
                    aArr[2] = x;
                    x = 0;
                    for (int num : bobMap.keySet()) {
                        bArr[x++] = num;
                    }
                    Arrays.sort(bArr);
                    x = bArr[0];
                    bArr[0] = bArr[2];
                    bArr[2] = x;
                }
                for (int j = 0; j < size; j++) {
                    if (aArr[j] > bArr[j]) {
                        a = true;
                        break;
                    } else if (aArr[j] < bArr[j]) {
                        b = true;
                        break;
                    }
                }
            }
            if (a) {
                System.out.println("Alice");
            }
            if (b) {
                System.out.println("Bob");
            }
            if (!a && !b) {
                System.out.println("Tie");
            }
        }
        scanner.close();
    }
}
