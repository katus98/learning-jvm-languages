package com.leetcode.main.interval1.q67;

/**
 * 二进制求和
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-26
 */
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int addFront = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 && j >= 0) {
            char x1 = a.charAt(i);
            char x2 = b.charAt(j);
            int res = (x1 - '0') + (x2 - '0') + addFront;
            switch (res) {
                case 0:
                    builder.insert(0, 0);
                    addFront = 0;
                    break;
                case 1:
                    builder.insert(0, 1);
                    addFront = 0;
                    break;
                case 2:
                    builder.insert(0, 0);
                    addFront = 1;
                    break;
                default:
                    builder.insert(0, 1);
                    addFront = 1;
            }
            i--;
            j--;
        }
        if (i >= 0) {
            addFront = tailProcess(builder, a, i, addFront);
        }
        if (j >= 0) {
            addFront = tailProcess(builder, b, j, addFront);
        }
        if (addFront == 1) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    private int tailProcess(StringBuilder builder, String str, int i, int addFront) {
        while (i >= 0) {
            char x = str.charAt(i);
            int res = (x - '0') + addFront;
            switch (res) {
                case 0:
                    builder.insert(0, 0);
                    addFront = 0;
                    break;
                case 1:
                    builder.insert(0, 1);
                    addFront = 0;
                    break;
                default:
                    builder.insert(0, 0);
                    addFront = 1;
            }
            i--;
        }
        return addFront;
    }
}
