package com.leetcode.exam.autumn.formal.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 找到可以用array数组中的个位数不限次数组成的大于n的最小整数
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-25
 */
public class Interview {
    public static void main(String[] args) {
        Interview interview = new Interview();
        System.out.println(interview.process(new int[]{1, 7, 3}, 1234));
        System.out.println(interview.process(new int[]{1, 7, 3}, 789));
        System.out.println(interview.process(new int[]{1, 7, 9}, 789));
        System.out.println(interview.process(new int[]{1, 2, 3}, 123));
        System.out.println(interview.process(new int[]{7, 8, 9}, 788));
        System.out.println(interview.process(new int[]{8}, 999));
        System.out.println(interview.process(new int[]{2, 1}, 789));
        System.out.println(interview.process(new int[]{1, 0}, 789));
    }

    private Set<Character> set;

    public int process(int[] array, int n) {
        char[] arr = String.valueOf(n).toCharArray();
        this.set = new HashSet<>();
        for (int a : array) {
            set.add(String.valueOf(a).toCharArray()[0]);
        }
        // 所有数的最小值
        char minValue = getMin();
        char t = getMinWithoutZero();
        // 不含0的最小值
        char minValueWithoutZero = t == '-' ? '0' : t;
        // 结果
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < arr.length) {
            char x = arr[i];
            if (set.contains(x) && i != arr.length - 1) {
                // 如果数组中包含当前数字而且不是最后一位
                builder.append(x);
            } else {
                // 如果不包含当前数字或者是最后一位
                // 获取比当前位更大一点的数字
                char minNum = getMinNum((char) (x + 1));
                if (minNum != '-') {
                    // 如果存在
                    builder.append(minNum);
                    // 之后的数位填写最小数字
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        builder.append(minValue);
                    }
                    // 结束
                    break;
                } else {
                    // 如果不存在比当前位更大的数字
                    // 向前回溯 j需要回溯的索引下标
                    for (int j = i - 1; j >= -1; j--) {
                        if (j == -1) {
                            // 如果回溯到了尽头, 直接生成位数多1的最小值
                            builder.delete(0, builder.length());
                            builder.append(minValueWithoutZero);
                            for (int k = 0; k < arr.length; k++) {
                                builder.append(minValue);
                            }
                        } else {
                            // 获取当前回溯位置比当前位置大一点的数
                            char minNum1 = getMinNum((char) (arr[j] + 1));
                            if (minNum1 != '-') {
                                // 如果存在删除之前添加的最后一位
                                builder.deleteCharAt(builder.length() - 1);
                                // 放入其中
                                builder.append(minNum1);
                                // 后续使用最小值填充
                                for (int k = 0; k < arr.length - j - 1; k++) {
                                    builder.append(minValue);
                                }
                                // 跳出回溯
                                break;
                            }
                            // 如果不存在则继续回溯
                        }
                    }
                }
            }
            i++;
        }
        return Integer.parseInt(builder.toString());
    }

    private char getMinNum(char x) {
        for (char i = x; i <= '9'; i++) {
            if (set.contains(i)) {
                return i;
            }
        }
        return '-';
    }

    private char getMinWithoutZero() {
        for (char i = '1'; i <= '9'; i++) {
            if (set.contains(i)) {
                return i;
            }
        }
        return '-';
    }

    private char getMin() {
        for (char i = '0'; i <= '9'; i++) {
            if (set.contains(i)) {
                return i;
            }
        }
        return '-';
    }
}
