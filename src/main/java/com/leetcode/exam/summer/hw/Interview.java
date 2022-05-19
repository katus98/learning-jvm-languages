package com.leetcode.exam.summer.hw;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-16
 */
public class Interview {
    public String process(String path) {
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }
        String[] items = path.split("/");
        boolean flag = true;
        for (int i = 0; i < items.length; i++) {
            switch (items[i]) {
                case "..":
                    items[i] = "";
                    flag = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if (!items[j].isEmpty()) {
                            items[j] = "";
                            flag = true;
                            break;
                        }
                    }
                    break;
                case ".":
                    items[i] = "";
                    break;
            }
        }
        if (!flag) return "/";
        StringBuilder builder = new StringBuilder("/");
        for (String item : items) {
            if (!item.isEmpty()) {
                builder.append(item).append("/");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        Interview interview = new Interview();
        System.out.println(interview.process("/home/"));
        System.out.println(interview.process("/a/a../b/./c/d"));
        System.out.println(interview.process("/a/..a/./c/d"));
        System.out.println(interview.process("/a/../../.."));
        System.out.println(interview.process("/a/x/../../f/../.."));
    }
}
