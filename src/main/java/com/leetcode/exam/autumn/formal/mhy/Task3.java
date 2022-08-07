package com.leetcode.exam.autumn.formal.mhy;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Task3 {
    private static final char[] COLORS = new char[]{'R', 'G', 'B'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] items = scanner.nextLine().split(" ");
            int p1 = Integer.parseInt(items[0]);
            int p2 = Integer.parseInt(items[1]);
            graphMap.get(p1).add(p2);
            graphMap.get(p2).add(p1);
        }
        scanner.close();
        int start = 1;
        for (int i = 1; i < n + 1; i++) {
            if (graphMap.get(i).size() == 1) {
                start = i;
                break;
            }
        }
        int i = 0;
        boolean[] visited = new boolean[n];
        char[] res = new char[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            for (int j = queue.size(); j > 0; j--) {
                int node = queue.remove();
                List<Integer> endNodes = graphMap.get(node);
                res[node - 1] = COLORS[i];
                visited[node - 1] = true;
                for (int endNode : endNodes) {
                    if (!visited[endNode - 1]) {
                        queue.add(endNode);
                    }
                }
            }
            i = (i + 1) % 3;
        }
        System.out.println(new String(res));
    }
}
