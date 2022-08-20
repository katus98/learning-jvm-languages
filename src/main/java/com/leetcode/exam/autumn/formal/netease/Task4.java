package com.leetcode.exam.autumn.formal.netease;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = array[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        long count = 0L;
        int start, end, leftSize, rightSize;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int edge = entry.getKey();
            List<Integer> indexList = entry.getValue();
            for (int i = 0; i < indexList.size() - 1; i++) {
                start = indexList.get(i);
                end = indexList.get(i + 1);
                leftSize = i + 1;
                rightSize = indexList.size() - i - 1;
                for (int j = start + 1; j < end; j++) {
                    if (array[j] < edge) {
                        count += (long) leftSize * rightSize;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
