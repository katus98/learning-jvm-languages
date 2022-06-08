package com.leetcode.main.interval701.q784;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-08
 */
public class Solution {
    private final List<String> resultList = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        this.resultList.clear();
        char[] chs = s.toLowerCase().toCharArray();
        permute(chs, 0);
        return resultList;
    }

    private void permute(char[] chs, int i) {
        for (int j = i; j < chs.length; j++) {
            if (Character.isLetter(chs[j])) {
                chs[j] -= 32;
                permute(chs, j + 1);
                chs[j] += 32;
            }
        }
        // 注意递归出口
        resultList.add(new String(chs));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCasePermutation("a1b2").forEach(System.out::println);
    }
}
