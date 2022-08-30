package com.leetcode.exam.autumn.formal.mt;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-29
 */
public class Interview1 {
    public int cal(String str) {
        int i;
        for (i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
        }
        return str.length() - i - 1;
    }
}
