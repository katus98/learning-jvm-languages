package com.leetcode.main.interval201.q287;

/**
 * 寻找重复数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-08
 */
public class Solution {
    /**
     * 将数组想象成链表nums[当前位置]=下一个位置
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     * 即按照寻找链表环入口的思路来做
     **/
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            // 快指针一次走两步
            fast = nums[nums[fast]];
            // 慢指针一次走一步
            slow = nums[slow];
            if (slow == fast) {
                // 如果快慢指针相遇
                fast = 0;
                // 快指针回到初始位置
                while (nums[slow] != nums[fast]) {
                    // 两个指针都一次走一步
                    fast = nums[fast];
                    slow = nums[slow];
                }
                // 直到两者再次相遇返回环的入口
                return nums[slow];
            }
        }
    }

    /**
     * 二分法
     */
    public int findDuplicate2(int[] nums) {
        // 重复元素数值的上下界
        int left = 1, right = nums.length - 1;
        int count, cur;
        while (left < right) {
            count = 0;
            // 取中间值
            cur = left + ((right - left) >> 1);
            // 统计小于等于中间值的元素个数
            for (int num : nums) {
                if (num <= cur) {
                    count++;
                }
            }
            if (count > cur) {
                // 如果数量大于中间值本身, 说明左侧或者中间值有重复
                right = cur;
            } else {
                // 否则中间值右侧有重复
                left = cur + 1;
            }
        }
        return left;
    }
}
