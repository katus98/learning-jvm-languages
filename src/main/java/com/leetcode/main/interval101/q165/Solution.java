package com.leetcode.main.interval101.q165;

/**
 * 比较版本号
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    /**
     * 按照标点分割, 每一项去除前导0之后, 填零补齐位数, 字符串比较
     */
    public int compareVersion(String version1, String version2) {
        String[] verArray1 = version1.split("\\.");
        String[] verArray2 = version2.split("\\.");
        int size = Math.max(verArray1.length, verArray2.length);
        for (int i = 0; i < size; i++) {
            String v1, v2;
            if (i < verArray1.length) {
                v1 = removeZeroPrefix(verArray1[i]);
            } else {
                v1 = "0";
            }
            if (i < verArray2.length) {
                v2 = removeZeroPrefix(verArray2[i]);
            } else {
                v2 = "0";
            }
            int c = compare(v1, v2);
            if (c != 0) {
                return c > 0 ? 1 : -1;
            }
        }
        return 0;
    }

    private String removeZeroPrefix(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return str.substring(i);
            }
        }
        return "0";
    }

    private int compare(String s1, String s2) {
        int size = Math.abs(s1.length() - s2.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append('0');
        }
        if (s1.length() > s2.length()) {
            builder.append(s2);
            s2 = builder.toString();
        } else {
            builder.append(s1);
            s1 = builder.toString();
        }
        return s1.compareTo(s2);
    }
}
