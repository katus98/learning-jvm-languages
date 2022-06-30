package com.leetcode.main.interval1301.q1346;

import java.util.Arrays;

/**
 * 检查整数及其两倍数是否存在
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public class Solution {
    /**
     * 要注意二分时正负处理逻辑不同
     */
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < arr.length && arr[start] < 0) start++;
        int[] array1 = new int[start];
        System.arraycopy(arr, 0, array1, 0, array1.length);
        for (int i = 0; i < array1.length / 2; i++) {
            int tmp = array1[i];
            array1[i] = array1[array1.length - i - 1];
            array1[array1.length - i - 1] = tmp;
        }
        while (end >= 0 && arr[end] >= 0) end--;
        int[] array2 = new int[arr.length - end - 1];
        System.arraycopy(arr, end + 1, array2, 0, array2.length);
        for (int i = 0; i < array1.length; i++) {
            array1[i] = -array1[i];
        }
        return checkIfExistA(array1) || checkIfExistA(array2);
    }

    private boolean checkIfExistA(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int start = i + 1, end = arr.length - 1, cur, x = arr[i] * 2;
            while (start < end) {
                cur = start + ((end - start) >> 1);
                if (arr[cur] > x) {
                    end = cur;
                } else if (arr[cur] < x) {
                    start = cur + 1;
                } else {
                    start = cur;
                    end = cur;
                }
            }
            if (arr[start] == x) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfExist(new int[]{-766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950, -454, -253, 824, -395, 155, 94, 894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373, -971, -813, -154, -765, 691, 812, 617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394, -506, -675, 523}));
    }
}
