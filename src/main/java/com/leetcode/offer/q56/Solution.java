package com.leetcode.offer.q56;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 * @see com.leetcode.main.q136.Solution
 */
public class Solution {
    /**
     * 出现两次的话先计算全体异或, 得到的数值就是两个唯一值的异或, 根据这个异或值中为1的为对原来的数组重新分成两组, 分别异或
     */
    public int[] singleNumbers(int[] nums) {
        int yhNum = calYH(nums);
        int keyNum = 1;
        for (int i = 0; i < 32; i++) {
            keyNum = (1 << i);
            if ((yhNum & keyNum) != 0) break;
        }
        List<Integer> list0 = new ArrayList<>(), list1 = new ArrayList<>();
        for (int num : nums) {
            if ((num & keyNum) == 0) {
                list0.add(num);
            } else {
                list1.add(num);
            }
        }
        return new int[]{calYH(list0), calYH(list1)};
    }

    private int calYH(int[] nums) {
        int yhNum = 0;
        for (int num : nums) {
            yhNum ^= num;
        }
        return yhNum;
    }

    private int calYH(List<Integer> nums) {
        int yhNum = 0;
        for (int num : nums) {
            yhNum ^= num;
        }
        return yhNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumbers(new int[]{7,1,7,2,6,6,3,1}));
    }
}
