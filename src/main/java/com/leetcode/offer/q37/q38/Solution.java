package com.leetcode.offer.q37.q38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 * @see com.leetcode.main.q46.Solution
 * @see com.leetcode.main.q47.Solution
 */
public class Solution {
    private final List<String> list = new ArrayList<>();
    private char[] chars;
    private boolean[] visited;
    private int n;

    public String[] permutation(String s) {
        this.chars = s.toCharArray();
        Arrays.sort(this.chars);
        this.n = s.length();
        this.visited = new boolean[n];
        arrange(0, new StringBuilder());
        return list.toArray(new String[0]);
    }

    private void arrange(int ix, StringBuilder builder) {
        if (ix == n) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && chars[i - 1] == chars[i] && !visited[i - 1])) {
                continue;
            }
            builder.append(chars[i]);
            visited[i] = true;
            arrange(ix + 1, builder);
            visited[i] = false;
            builder.deleteCharAt(ix);
        }
    }
}
