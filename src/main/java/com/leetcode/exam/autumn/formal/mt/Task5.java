package com.leetcode.exam.autumn.formal.mt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        int maxMoney = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int index = queue.poll();
                int left = (index + 1) * 2 - 1;
                int right = (index + 1) * 2;
                if (left < n) {
                    array[left] += array[index];
                    maxMoney = Math.max(maxMoney, array[left]);
                    queue.add(left);
                }
                if (right < n) {
                    array[right] += array[index];
                    maxMoney = Math.max(maxMoney, array[right]);
                    queue.add(right);
                }
            }
        }
        System.out.println(maxMoney);
    }
}
