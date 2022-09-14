package com.leetcode.main.interval401.q448;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-13
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 第一次扫描: 扫描到的元素对应位置的元素变成负值
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
        }
        // 扫描所有正值的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
