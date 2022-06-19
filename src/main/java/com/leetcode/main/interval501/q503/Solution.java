package com.leetcode.main.interval501.q503;

import java.util.Arrays;

/**
 * 下一个更大元素 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-19
 */
public class Solution {
    /**
     * 暴力双层循环
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int next = getNum(nums, i + j);
                if (next > nums[i]) {
                    res[i] = next;
                    break;
                }
            }
        }
        return res;
    }

    private int getNum(int[] nums, int i) {
        return nums[i % nums.length];
    }

    /**
     * 保存之前结果的下标, 然后加大步长从而加快速度 (核心思想与单调栈应该是一样的, 但是未理解单调栈, 需要之后理解)
     * 原创加速算法
     */
    public int[] nextGreaterElements2(int[] nums) {
        // 用于记录结果
        int[] res = new int[nums.length];
        // 用于记录下一个更大元素的位置
        int[] indexes = new int[nums.length];
        // 初始化结果数组
        Arrays.fill(res, -1);
        Arrays.fill(indexes, -1);
        // 逆序迭代
        for (int i = nums.length - 1; i >= 0; i--) {
            // 从当前位置i右边第一个元素开始
            int j = 1;
            while (j < nums.length) {
                int nex = getNum(nums, i + j);
                // 如果符合大于条件
                if (nex > nums[i]) {
                    // 记录结果与位置
                    res[i] = nex;
                    indexes[i] = (i + j) % nums.length;
                    break;
                }
                // 如果不符合大于条件, 获取当前位置元素的下一个更大元素
                int index = getNum(indexes, i + j);
                if (index != -1) {
                    int nexRes = getNum(res, i + j);
                    // 如果已经计算了下一个更大元素
                    // 跳转到下一个更大元素的位置
                    j = index - i <= 0 ? index - i + nums.length : index - i;
                    if (nexRes <= nums[i]) {
                        // 如果i位置的元素比下一个更大元素更大
                        // 跳到下一个更大元素的下一个位置
                        j++;
                    }
                } else {
                    // 如果没有计算下一个更大元素
                    // 扫描下一个位置
                    j++;
                }
            }
        }
        return res;
    }

    /**
     * 优化空间占用
     */
    public int[] nextGreaterElements3(int[] nums) {
        // 起初用来记录下一个元素的位置, 最后用于记录结果
        int[] res = new int[nums.length];
        // 初始化结果数组
        Arrays.fill(res, -1);
        // 逆序迭代
        for (int i = nums.length - 1; i >= 0; i--) {
            // 从当前位置i右边第一个元素开始
            int j = 1;
            while (j < nums.length) {
                int nex = getNum(nums, i + j);
                // 如果符合大于条件
                if (nex > nums[i]) {
                    // 记录结果的位置
                    res[i] = (i + j) % nums.length;
                    break;
                }
                // 如果不符合大于条件, 获取当前位置元素的下一个更大元素
                int index = getNum(res, i + j);
                if (index != -1) {
                    int nexRes = nums[index];
                    // 如果已经计算了下一个更大元素
                    // 跳转到下一个更大元素的位置
                    j = index - i <= 0 ? index - i + nums.length : index - i;
                    if (nexRes <= nums[i]) {
                        // 如果i位置的元素比下一个更大元素更大
                        // 跳到下一个更大元素的下一个位置
                        j++;
                    }
                } else {
                    // 如果没有计算下一个更大元素
                    // 扫描下一个位置
                    j++;
                }
            }
        }
        // 将下一个更大元素位置替换为元素本身
        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1) {
                res[i] = nums[res[i]];
            }
        }
        return res;
    }
}
