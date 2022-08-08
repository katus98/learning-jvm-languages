package com.leetcode.main.interval101.q187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重复的DNA序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-08
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String seg = s.substring(i, i + 10);
            map.put(seg, map.getOrDefault(seg, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                resList.add(entry.getKey());
            }
        }
        return resList;
    }

    private static final int N = (int) 1e5 + 10, P = 131313;
    int[] hashes = new int[N], p = new int[N];

    public List<String> findRepeatedDnaSequences2(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            hashes[i] = hashes[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = hashes[j] - hashes[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + 10 - 1));
            map.put(hash, cnt + 1);
        }
        return ans;
    }
}
