package com.leetcode.main.interval401.q468;

/**
 * 验证IP地址
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-21
 */
public class Solution {
    public String validIPAddress(String queryIP) {
        String[] items;
        if (queryIP.endsWith(":") || queryIP.endsWith(".")) {
            return "Neither";
        }
        if (queryIP.contains(".")) {   // IPv4
            items = queryIP.split("\\.");
            if (items.length != 4) {
                return "Neither";
            }
            for (String item : items) {
                switch (item.length()) {
                    case 1:
                        char ch = item.charAt(0);
                        if (!Character.isDigit(ch)) {
                            return "Neither";
                        }
                        break;
                    case 2:
                        char ch1 = item.charAt(0);
                        char ch2 = item.charAt(1);
                        if (ch1 == '0' || !Character.isDigit(ch1) || !Character.isDigit(ch2)) {
                            return "Neither";
                        }
                        break;
                    case 3:
                        if (!Character.isDigit(item.charAt(0)) || !Character.isDigit(item.charAt(1)) || !Character.isDigit(item.charAt(2))) {
                            return "Neither";
                        }
                        if (item.charAt(0) == '0') {
                            return "Neither";
                        }
                        if (Integer.parseInt(item) > 255) {
                            return "Neither";
                        }
                        break;
                    default:
                        return "Neither";
                }
            }
            return "IPv4";
        } else {   // IPv6
            items = queryIP.split(":");
            if (items.length != 8) {
                return "Neither";
            }
            for (String item : items) {
                if (item.isEmpty() || item.length() > 4) {
                    return "Neither";
                }
                for (int i = 0; i < item.length(); i++) {
                    char ch = item.charAt(i);
                    if (!(Character.isDigit(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        // 注意split对于前导空是进行分割的, 后导空是不进行分割的
        System.out.println("1,2,3,4,5".split(",").length);
        System.out.println(",,,,,1,2,3,4,5".split(",").length);
        System.out.println("1,2,3,4,5,,,,,".split(",").length);
        System.out.println(",,,,,1,2,3,4,5,,,,,".split(",").length);
    }
}
