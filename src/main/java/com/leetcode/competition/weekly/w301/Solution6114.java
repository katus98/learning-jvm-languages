package com.leetcode.competition.weekly.w301;

/**
 * 移动片段得到字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
public class Solution6114 {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;
        String r1 = start.replace("_", "");
        if (!r1.equals(target.replace("_", ""))) return false;
        int index1 = 0, index2 = 0;
        Letter[] startLetters = new Letter[r1.length()];
        Letter[] targetLetters = new Letter[r1.length()];
        for (int i = 0; i < start.length(); i++) {
            char ch1 = start.charAt(i), ch2 = target.charAt(i);
            if (ch1 != '_') {
                startLetters[index1++] = new Letter(ch1, i);
            }
            if (ch2 != '_') {
                targetLetters[index2++] = new Letter(ch2, i);
            }
        }
        for (int i = 0; i < startLetters.length; i++) {
            Letter startLetter = startLetters[i];
            Letter targetLetter = targetLetters[i];
            if (startLetter.letter == 'L') {
                if (targetLetter.index > startLetter.index) {
                    return false;
                }
            } else {
                if (targetLetter.index < startLetter.index) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Letter {
        char letter;
        int index;

        public Letter(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution6114 solution6114 = new Solution6114();
        System.out.println(solution6114.canChange("_L__R__R_", "L______RR"));
        System.out.println(solution6114.canChange("R_L_", "__LR"));
        System.out.println(solution6114.canChange("_R", "R_"));
    }
}
