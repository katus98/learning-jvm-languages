package com.leetcode.exam.autumn.formal.red;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-28
 */
public class Task3 {
    private static List[] graphArray;
    private static Map<Integer, Integer> notVisitedMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        graphArray = new List[n];
        for (int i = 0; i < n; i++) {
            graphArray[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < array.length; i++) {
            int a = i + 1;
            int b = array[i] - 1;
            graphArray[a].add(b);
            graphArray[b].add(a);
        }
        int count = 0;
        notVisitedMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!graphArray[i].isEmpty()) {
                notVisitedMap.put(i, graphArray[i].size());
            }
            if (graphArray[i].size() == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int node = queue.poll();
                if (!notVisitedMap.containsKey(node)) continue;
                int endNode = -1, minDegree = Integer.MAX_VALUE;
                for (Object o : graphArray[node]) {
                    int end = (Integer) o;
                    if (notVisitedMap.containsKey(o)) {
                        int degree = 0;
                        for (Object x : graphArray[end]) {
                            if (notVisitedMap.containsKey(x)) {
                                degree++;
                            }
                        }
                        notVisitedMap.put(end, degree);
                        if (degree < minDegree) {
                            endNode = end;
                        }
                    }
                }
                delNode(node);
                if (endNode != -1) {
                    delNode(endNode);
                    count++;
                }
            }
            for (Map.Entry<Integer, Integer> entry : notVisitedMap.entrySet()) {
                if (entry.getValue() == 1) {
                    queue.add(entry.getKey());
                }
            }
        }
        System.out.println(count);
    }

    private static void delNode(int node) {
        notVisitedMap.remove(node);
        for (Object o : graphArray[node]) {
            int i = (Integer) o;
            if (notVisitedMap.containsKey(i)) {
                if (notVisitedMap.get(i) > 1) {
                    notVisitedMap.put(i, notVisitedMap.get(i) - 1);
                } else {
                    notVisitedMap.remove(i);
                }
            }
        }
    }
}
