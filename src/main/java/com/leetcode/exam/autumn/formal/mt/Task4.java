package com.leetcode.exam.autumn.formal.mt;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] items = scanner.nextLine().split(" ");
        scanner.close();
        int[] array = Arrays.stream(items).mapToInt(Integer::parseInt).toArray();
        s3(n, array);
    }

    public static void s1(int n, int[] array) {
        long count = 0L;
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = 3L * array[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                long sum = (long) array[i] + array[j];
                if (map.containsKey(sum)) {
                    List<Integer> list = map.get(sum);
                    for (int ss : list) {
                        if (ss > i && ss < j) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void s2(int n, int[] array) {
        long count = 0L;
        Map<Long, Integer> allMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            allMap.put((long) array[i], allMap.getOrDefault((long) array[i], 0) + 1);
        }
        for (int i = 0; i < n - 2; i++) {
            Map<Long, Integer> cMap = new HashMap<>();
            for (int j = 0; j <= i; j++) {
                cMap.put((long) array[j], cMap.getOrDefault((long) array[j], 0) + 1);
            }
            for (int j = i + 1; j < n - 1; j++) {
                cMap.put((long) array[j], cMap.getOrDefault((long) array[j], 0) + 1);
                long res = array[j] * 3L - array[i];
                count += allMap.getOrDefault(res, 0) - cMap.getOrDefault(res, 0);
            }
        }
        System.out.println(count);
    }

    public static void s3(int n, int[] array) {
        long count = 0L;
        Map<Long, Integer> allMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            allMap.put((long) array[i], allMap.getOrDefault((long) array[i], 0) + 1);
        }
        for (int k = n - 1; k >= 2; k--) {
            Map<Long, Integer> cMap = new HashMap<>();
            for (int j = n - 1; j >= k; j--) {
                cMap.put((long) array[j], cMap.getOrDefault((long) array[j], 0) + 1);
            }
            for (int j = k - 1; j >= 1; j--) {
                cMap.put((long) array[j], cMap.getOrDefault((long) array[j], 0) + 1);
                long res = array[j] * 3L - array[k];
                count += allMap.getOrDefault(res, 0) - cMap.getOrDefault(res, 0);
            }
        }
        System.out.println(count);
    }
}
