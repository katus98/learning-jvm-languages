package com.leetcode.exam.autumn.formal.zoom;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-10
 */
public class Task1 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        Map<Integer, Character> colorMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String colors = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            colorMap.put(i + 1, colors.charAt(i));
            graphMap.put(i + 1, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] items = scanner.nextLine().split(" ");
            int i1 = Integer.parseInt(items[0]);
            int i2 = Integer.parseInt(items[1]);
            graphMap.get(i1).add(i2);
            graphMap.get(i2).add(i1);
        }
        scanner.close();
        long totalWei = 0L;
        long[] blues = new long[n];
        long[] reds = new long[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        if (colorMap.get(1) == 'R') {
            reds[0] = 1;
        } else {
            blues[0] = 1;
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int end : graphMap.get(node)) {
                if (reds[end - 1] == 0 && blues[end - 1] == 0) {
                    if (colorMap.get(end) == 'R') {
                        reds[end - 1] = reds[node - 1] + 1;
                        blues[end - 1] = blues[node - 1];
                    } else {
                        reds[end - 1] = reds[node - 1];
                        blues[end - 1] = blues[node - 1] + 1;
                    }
                    queue.add(end);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            totalWei += Math.abs(blues[i] - reds[i]);
        }
        System.out.println(totalWei);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String colors = scanner.nextLine();
        List<Integer>[] graph = new List<>[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] items = scanner.nextLine().split(" ");
            int i1 = Integer.parseInt(items[0]);
            int i2 = Integer.parseInt(items[1]);
            graph[i1].add(i2);
            graph[i2].add(i1);
        }
        scanner.close();
        long totalWei = 0L;
        long[] blues = new long[n];
        long[] reds = new long[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        if (colors.charAt(0) == 'R') {
            reds[0] = 1;
        } else {
            blues[0] = 1;
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int end : graph[node]) {
                if (reds[end - 1] == 0 && blues[end - 1] == 0) {
                    if (colors.charAt(end - 1) == 'R') {
                        reds[end - 1] = reds[node - 1] + 1;
                        blues[end - 1] = blues[node - 1];
                    } else {
                        reds[end - 1] = reds[node - 1];
                        blues[end - 1] = blues[node - 1] + 1;
                    }
                    queue.add(end);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            totalWei += Math.abs(blues[i] - reds[i]);
        }
        System.out.println(totalWei);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] colors = scanner.nextLine().toCharArray();
        List<Integer>[] graph = new List<>[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] items = scanner.nextLine().split(" ");
            int i1 = Integer.parseInt(items[0]);
            int i2 = Integer.parseInt(items[1]);
            graph[i1 - 1].add(i2 - 1);
            graph[i2 - 1].add(i1 - 1);
        }
        scanner.close();
        dfs(graph, new boolean[n], colors, 0, 0, 0);
        System.out.println(totalWei);
    }

    private static long totalWei = 0L;

    private static void dfs(List<Integer>[] graph, boolean[] visited, char[] colors, int b, int r, int i) {
        if (visited[i]) return;
        visited[i] = true;
        if (colors[i] == 'R') {
            r++;
        } else {
            b++;
        }
        totalWei += Math.abs(r - b);
        for (int j : graph[i]) {
            dfs(graph, visited, colors, b, r, j);
        }
    }
}
