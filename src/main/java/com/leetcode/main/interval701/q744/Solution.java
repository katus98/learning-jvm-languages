package com.leetcode.main.interval701.q744;

/**
 * 寻找比目标字母大的最小字母
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-25
 */
public class Solution {
    /**
     * 另一种二分法范式
     * 不是寻找target而是寻找比target大或者小一点的元素
     * 借助一个额外的变量存储结果, 循环条件start <= end, 分支都需要变化区间+-1
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1, cur;
        char res = '0';
        while (start <= end) {
            cur = start + ((end - start) >> 1);
            if (letters[cur] > target) {
                res = letters[cur];
                end = cur - 1;
            } else {
                start = cur + 1;
            }
        }
        return res == '0' ? letters[0] : res;
    }
}
