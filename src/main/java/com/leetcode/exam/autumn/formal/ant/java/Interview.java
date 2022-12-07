package com.leetcode.exam.autumn.formal.ant.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-12-05
 */
public class Interview {
    private static final int[][] DIRS4 = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int[][] DIRS8 = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    private int m, n;
    private char[][] grids;

    public long cal(char[][] grids) {
        this.grids = grids;
        this.m = grids.length;
        this.n = m > 0 ? grids[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] == 'x' && nearO(i, j)) {
                    if (dfsJudge(i, j)) {
                        dfs(i, j);
                    } else {
                        clear();
                    }
                }
            }
        }
        long count = 0L;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] == 'o' || grids[i][j] == '+') {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (grids[i][j] == 'x' || grids[i][j] == '-') {
            grids[i][j] = '+';
            for (int[] dir : DIRS4) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (valid(ni, nj)) {
                    if (grids[ni][nj] == 'x' || grids[ni][nj] == '-') {
                        dfs(ni, nj);
                    }
                }
            }
        }
    }

    private boolean dfsJudge(int i, int j) {
        boolean v;
        if (grids[i][j] == 'x') {
            grids[i][j] = '-';
            for (int[] dir : DIRS4) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (valid(ni, nj)) {
                    if (grids[ni][nj] == 'x') {
                        v = dfsJudge(ni, nj);
                        if (!v) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void clear() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] == '-') {
                    grids[i][j] = 'x';
                }
            }
        }
    }

    private boolean nearO(int i, int j) {
        if (!edge(i, j)) {
            for (int[] dir : DIRS8) {
                if (grids[i + dir[0]][j + dir[1]] == 'o') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean edge(int i, int j) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = a[0], n = a[1];
        char[][] grids = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grids[i][j] = line.charAt(j);
            }
        }
        scanner.close();
        Interview interview = new Interview();
        System.out.println(interview.cal(grids));
    }
}
