package com.leetcode.offer.q45;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class Solution {
    /**
     * 原创, 对数值类型进行排序 略麻烦
     */
    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            private final Deque<Integer> stack = new LinkedList<>();

            @Override
            public int compare(Integer o1, Integer o2) {
                int[] e1 = explode(o1), e2 = explode(o2);
                int i;
                for (i = 0; i < e1.length && i < e2.length; i++) {
                    int res = e1[i] - e2[i];
                    if (res != 0) return res;
                }
                return (o1 * pow10(e2.length) + o2) - (o2 * pow10(e1.length) + o1);
            }

            private int[] explode(int n) {
                if (n == 0) return new int[]{0};
                while (n > 0) {
                    stack.push(n % 10);
                    n /= 10;
                }
                int[] res = new int[stack.size()];
                for (int i = 0; i < res.length; i++) {
                    res[i] = stack.pop();
                }
                return res;
            }

            private int pow10(int n) {
                if (n == 0) return 1;
                int res = 10;
                for (int i = 0; i < n - 1; i++) {
                    res *= 10;
                }
                return res;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer num : list) {
            builder.append(num);
        }
        return builder.toString();
    }

    /**
     * 直接对字符串进行自定义排序
     */
    public String minNumber2(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder builder = new StringBuilder();
        for (String num : list) {
            builder.append(num);
        }
        return builder.toString();
    }
}
