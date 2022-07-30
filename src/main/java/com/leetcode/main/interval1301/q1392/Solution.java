package com.leetcode.main.interval1301.q1392;

/**
 * 最长快乐前缀
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-30
 */
public class Solution {
    /**
     * 暴力超时非常迅速
     */
    public String longestPrefix(String s) {
        for (int i = s.length() - 1; i > 0; i--) {
            String sub = s.substring(0, i);
            if (sub.equals(s.substring(s.length() - i))) return sub;
        }
        return "";
    }

    /**
     * KMP算法
     */
    public String longestPrefix2(String s) {
        int n = s.length();
        int[] next = new int[n];
        int i = 1;
        int now = 0; //通过now来转化下一个长度
        while (i < n) {
            if (s.charAt(i) == s.charAt(now)) {
                now++;
                next[i++] = now;
            } else if (now == 0) {
                i++;
            } else {
                now = next[now - 1];
            }
        }
        return next[n - 1] == 0 ? "" : s.substring(0, next[n - 1]);
    }

    /**
     * 哈希算法 (存疑)
     */
    public String longestPrefix3(String s) {
        int n = s.length();
        int[] h = new int[n + 1], p = new int[n + 1];
        p[0] = 1;
        int base = 131;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * base + s.charAt(i - 1);
            p[i] = p[i - 1] * base;
        }
        String ans = "";
        for (int i = 1; i < n; i++) {
            int hash1 = h[i];
            int hash2 = h[n] - h[n - i] * p[i];
            if (hash1 == hash2) {
                ans = s.substring(0, i);
            }
        }
        return ans;
    }
}
