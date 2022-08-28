package com.leetcode.exam.autumn.formal.jd;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-27
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        Map<Integer, Unit> map0 = new HashMap<>(), map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (map0.containsKey(array[i])) {
                    map0.get(array[i]).count++;
                } else {
                    map0.put(array[i], new Unit(array[i], 1));
                }
            } else {
                if (map1.containsKey(array[i])) {
                    map1.get(array[i]).count++;
                } else {
                    map1.put(array[i], new Unit(array[i], 1));
                }
            }
        }
        List<Unit> list0 = new ArrayList<>(map0.values()), list1 = new ArrayList<>(map1.values());
        list0.sort((o1, o2) -> -Integer.compare(o1.count, o2.count));
        list1.sort((o1, o2) -> -Integer.compare(o1.count, o2.count));
        int i = 0, j = 0;
        while (i < list0.size() && j < list1.size() && list0.get(i).num == list1.get(j).num) {
            if (list0.get(i).count < list1.get(j).count) {
                i++;
            } else {
                j++;
            }
        }
        if (i < list0.size() && j < list1.size() && list0.get(i).num != list1.get(j).num) {
            System.out.println(n - list0.get(i).count - list1.get(j).count);
        } else if (i == list0.size()) {
            System.out.println(n - list1.get(j).count);
        } else if (j == list1.size()) {
            System.out.println(n - list1.get(i).count);
        } else {
            System.out.println(0);
        }
    }

    public static class Unit {
        int num;
        int count;

        public Unit(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
