package com.leetcode.exam.autumn.formal.zoom;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-10
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String, Set<String>> userMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] items = scanner.nextLine().split(" ");
            int opt = Integer.parseInt(items[0]);
            String name = items[1];
            if (opt == 1) {
                String[] company = scanner.nextLine().split(" ");
                Set<String> set = new HashSet<>(Arrays.asList(company));
                userMap.put(name, set);
            } else {
                if (!userMap.containsKey(name)) {
                    System.out.println("error");
                }
                // todo
            }
        }
    }

    public static class Node {
        Set<String> companySet;
        Set<String> userSet;

        public Node(Set<String> companySet) {
            this.companySet = companySet;
        }
    }
}
