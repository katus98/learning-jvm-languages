package com.leetcode.main.interval1.q89;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-26
 */
public class Solution {
    /**
     * 对称生成
     * 在原有序列的基础上镜像向右翻转一倍
     * 然后将翻转出来的最高位变成1
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1;
        }
        return list;
    }
}
