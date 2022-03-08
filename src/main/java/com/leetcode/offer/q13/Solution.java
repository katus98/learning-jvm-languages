package com.leetcode.offer.q13;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 */
public class Solution {
    private final Set<String> VISIT = new HashSet<>();

    public int movingCount(int m, int n, int k) {
        return dfs(0, 0, m, n, k);
    }

    /**
     * 深度优先
     */
    private int dfs(int i, int j, int m, int n, int k) {
        if (checkValid(i, j, m, n, k)) {
            VISIT.add(i + ":" + j);
            return 1 + dfs(i + 1, j, m, n, k) + dfs(i - 1, j, m, n, k) + dfs(i, j + 1, m, n, k) + dfs(i, j - 1, m, n, k);
        } else {
            return 0;
        }
    }

    private boolean checkValid(int i, int j, int m, int n, int k) {
        return i >= 0 && j >= 0 && i < m && j < n && !VISIT.contains(i + ":" + j) && calDigital(i) + calDigital(j) <= k;
    }

    private boolean checkValid(int[] is, int m, int n, int k) {
        return checkValid(is[0], is[1], m, n, k);
    }

    private int calDigital(int n) {
        int digital = 0;
        while (n > 0) {
            digital += n % 10;
            n /= 10;
        }
        return digital;
    }

    /**
     * 广度优先
     */
    private int bfs(int m, int n, int k) {
        int count = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.push(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] is = queue.pop();
            if (checkValid(is, m, n, k)) {
                count++;
                VISIT.add(is[0] + ":" + is[1]);
                queue.push(new int[]{is[0] - 1, is[1]});
                queue.push(new int[]{is[0] + 1, is[1]});
                queue.push(new int[]{is[0], is[1] - 1});
                queue.push(new int[]{is[0], is[1] + 1});
            }
        }
        return count;
    }

    /**
     * 递推关系, 只要当前角标符合条件, 则只要左上符合条件即可符合条件
     */
    private int dy(int m, int n, int k) {
        boolean[][] arrived = new boolean[m][n];
        arrived[0][0] = true;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (calDigital(i) + calDigital(j) <= k) {
                    if (i - 1 >= 0) {
                        arrived[i][j] |= arrived[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        arrived[i][j] |= arrived[i][j - 1];
                    }
                    count += arrived[i][j] ? 1 : 0;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(movingCount(38, 15, 9));
    }
}
