package com.leetcode.exam.autumn.pre.microsoft;

/**
 * 青蛙最远距离
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Task2 {
    public int solution(int[] blocks) {
        int n = blocks.length, res = 0;
        int[] dpLeft = new int[n], dpRight = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] <= blocks[i + 1]) {
                dpRight[i] = dpRight[i + 1] + 1;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (blocks[i] <= blocks[i - 1]) {
                dpLeft[i] = dpLeft[i - 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (dpLeft[i] + dpRight[i] > res) {
                res = dpLeft[i] + dpRight[i];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.solution(new int[]{2, 6, 8, 5}));
        System.out.println(task2.solution(new int[]{1, 5, 5, 2, 6}));
        System.out.println(task2.solution(new int[]{1, 1}));
        System.out.println(task2.solution(new int[]{1, 2}));
        System.out.println(task2.solution(new int[]{1}));
    }
}
