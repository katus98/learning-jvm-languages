package com.leetcode.main.interval101.q167;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-05
 */
public class Solution {

    /**
     * 暴力解法会超时
     */
    public int[] twoSum(int[] numbers, int target) {
        int i1, i2 = 0;
        outer:
        for (i1 = 0; i1 < numbers.length - 1; i1++) {
            for (i2 = i1 + 1; i2 < numbers.length; i2++) {
                if (numbers[i1] + numbers[i2] == target) {
                    break outer;
                }
            }
        }
        return new int[]{i1 + 1, i2 + 1};
    }

    /**
     * NlogN, 外层遍历, 内层二分
     */
    public int[] twoSum2(int[] numbers, int target) {
        int i1, i2 = 0;
        outer:
        for (i1 = 0; i1 < numbers.length - 1; i1++) {
            int start = i1 + 1, end = numbers.length - 1;
            i2 = start;
            while (start <= end) {
                i2 = start + (end - start) / 2;
                if (numbers[i2] + numbers[i1] < target) {
                    start = i2 + 1;
                } else if (numbers[i2] + numbers[i1] > target) {
                    end = i2 - 1;
                } else {
                    break outer;
                }
            }
        }
        return new int[]{i1 + 1, i2 + 1};
    }

    /**
     * 双指针: 两侧指针向中间移动, 通过求和比较大小来确定移动哪个指针
     */
    public int[] twoSum3(int[] numbers, int target) {
        int i1 = 0, i2 = numbers.length - 1;
        while (i1 < i2) {
            if (numbers[i1] + numbers[i2] == target) {
                break;
            } else if (numbers[i1] + numbers[i2] > target) {
                i2--;
            } else {
                i1++;
            }
        }
        return new int[]{i1 + 1, i2 + 1};
    }
}
