package com.leetcode.offer.q21;

import org.junit.jupiter.api.Test;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {
    private int[] nums;

    /**
     * 双指针
     */
    public int[] exchange(int[] nums) {
        this.nums = nums;
        int i = getFirstEven(0), j = getLastOdd(nums.length - 1), temp;
        while (i < j && isValid(i) && isValid(j)) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i = getFirstEven(i);
            j = getLastOdd(j);
        }
        return nums;
    }

    private int getFirstEven(int i) {
        while (isValid(i) && isOdd(nums[i])) {
            i++;
        }
        return i;
    }

    private int getLastOdd(int i) {
        while (isValid(i) && isEven(nums[i])) {
            i--;
        }
        return i;
    }

    private boolean isValid(int i) {
        return i >= 0 && i < nums.length;
    }

    private boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }

    /**
     * 双指针简化
     */
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && isOdd(nums[i])) i++;
            while (i < j && isEven(nums[j])) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 快慢指针
     */
    public int[] exchange3(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) swap(nums, slow++, fast);
            fast++;
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test() {
        exchange(new int[]{1, 2, 3, 4, 5});
    }
}
