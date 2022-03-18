package com.leetcode.offer.q46;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class Solution {
    private int[] nums;
    private int count;

    /**
     * 原创dfs
     */
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        this.nums = new int[chars.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        this.count = 0;
        dfs(0);
        return count;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            count++;
            return;
        }
        dfs(i + 1);
        if (i < nums.length - 1) {
            if (nums[i] == 1) {
                dfs(i + 2);
            } else if (nums[i] == 2 && nums[i + 1] <= 5) {
                dfs(i + 2);
            }
        }
    }

    /**
     * 动态规划, DP给我的印象就是抓住事物发展规律中的一个步骤(往往是最后一个步骤)
     * 用f(i)代表这个步骤, 前一个步骤用f(i-1)代替来实现i这个步骤
     */
    public int translateNum2(int num) {
        return dp(num);
    }

    private int dp(int num) {
        if (num < 10) return 1;
        if (num % 100 <= 25) {
            return dp(num / 10) + dp(num / 100);
        } else {
            return dp(num / 10);
        }
    }
}
