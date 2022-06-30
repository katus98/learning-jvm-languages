package com.leetcode.main.interval1301.q1337;

import java.util.*;

/**
 * 矩阵中战斗力最弱的 K 行
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = m > 0 ? mat[0].length : 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] array = mat[i];
            int start = 0, end = n - 1, cur;
            while (start < end) {
                cur = start + ((end - start) >> 1);
                if (array[cur] == 1) {
                    start = cur + 1;
                } else {
                    end = cur;
                }
            }
            if (array[n - 1] == 1) start = n;
            List<Integer> list = map.getOrDefault(start, new ArrayList<>());
            list.add(i);
            map.put(start, list);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(i)) {
                resList.addAll(map.get(i));
            }
        }
        resList.forEach(i -> System.out.print(i + " "));
        System.out.println();
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.kWeakestRows(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}}, 3)));
    }
}
