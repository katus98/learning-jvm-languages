package com.leetcode.exam.summer.hw;

import com.leetcode.main.q315.Solution;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-11
 * @see Solution
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        int[] blessing = toBlessing(n, nums);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.printf("%d", blessing[i]);
            } else {
                System.out.printf("%d ", blessing[i]);
            }
        }
    }

    private static int[] toBlessing(int n, int[] nums) {
        int[] blessing = new int[n];
        boolean[] all = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int j = i; j < n; j++) {
                if (num > nums[j]) {
                    blessing[i]++;
                    if (all[i]) {
                        blessing[i] += blessing[j];
                        break;
                    }
                }
            }
            if (blessing[i] == n - i - 1) {
                all[i] = true;
            }
        }
        return blessing;
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (end > start) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid, temp);
            mergeSort(nums, mid + 1, end, temp);
            merge(nums, start, mid, end, temp);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int c = start, c1 = start, c2 = mid + 1;
        while (c1 <= mid && c2 <= end) {
            if (nums[c1] < nums[c2]) {
                temp[c] = nums[c1++];
            } else {
                temp[c] = nums[c2++];
            }
            c++;
        }
        while (c1 <= mid) {
            temp[c++] = nums[c1++];
        }
        while (c2 <= end) {
            temp[c++] = nums[c2++];
        }
    }
}
