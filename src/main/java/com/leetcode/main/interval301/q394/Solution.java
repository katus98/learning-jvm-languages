package com.leetcode.main.interval301.q394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-30
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        Deque<Unit> stack = new LinkedList<>();
        Unit unit = new Unit();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (unit.digitStartIndex == -1) {
                    unit.digitStartIndex = i;
                }
            } else if (ch == '[') {
                unit.symbolIndex = i;
                stack.push(unit);
                unit = new Unit();
            } else if (ch == ']') {
                Unit popUnit = stack.pop();
                int count = Integer.parseInt(s.substring(popUnit.digitStartIndex, popUnit.symbolIndex));
                String subStr = s.substring(popUnit.symbolIndex + 1, i);
                builder.delete(0, builder.length());
                builder.append(s, 0, popUnit.digitStartIndex);
                for (int j = 0; j < count; j++) {
                    builder.append(subStr);
                }
                builder.append(s.substring(i + 1));
                s = builder.toString();
                i += count * subStr.length() - (i - popUnit.digitStartIndex + 1);
            }
        }
        return s;
    }

    public static class Unit {
        int digitStartIndex;
        int symbolIndex;

        public Unit() {
            this(-1, -1);
        }

        public Unit(int digitStartIndex, int symbolIndex) {
            this.digitStartIndex = digitStartIndex;
            this.symbolIndex = symbolIndex;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}
