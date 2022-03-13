package com.leetcode.main.q189;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-04
 */
public class Solution {

    /**
     * 务必注意Java的内存模型, 单纯修改引用无法更改数组内容
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] array = new int[nums.length];
        for (int i = array.length - k, j = 0; i < array.length; i++, j++) {
            array[j] = nums[i];
        }
        for (int i = 0; i < array.length - k; i++) {
            array[i + k] = nums[i];
        }
        for (int i = 0; i < array.length; i++) {
            nums[i] = array[i];
        }
    }

    /**
     * 通过反转数组来达成目的
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1,2,3,4,5,6}, 3);
    }
}
