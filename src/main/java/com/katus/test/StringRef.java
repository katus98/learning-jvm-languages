package com.katus.test;

import java.util.regex.*;

public class StringRef {
    public static void main(String[] args) {
        String origin = "abcabcabcdefabc";
        String[] strs = {"abc+", "(abc)+", "(abc){2,}"};
        for (String str : strs) {
            System.out.println(str);
            Pattern pattern = Pattern.compile(str);
            Matcher matcher = pattern.matcher(origin);
            System.out.println(matcher.lookingAt());
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
