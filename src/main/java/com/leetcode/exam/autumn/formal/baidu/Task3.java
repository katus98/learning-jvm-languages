package com.leetcode.exam.autumn.formal.baidu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-13
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long forCount = 0L;
        Deque<Boolean> deque = new LinkedList<>();
        boolean flag = false, forFlag = false;
        long maxSize = 0L;
        while (true) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '{') {
                    flag = true;
                    if (forFlag) {
                        deque.push(true);
                        forCount++;
                        maxSize = Math.max(maxSize, forCount);
                        forFlag = false;
                    } else {
                        deque.push(false);
                    }
                } else if (ch == '}') {
                    Boolean isFor = deque.pop();
                    if (isFor) {
                        forCount--;
                    }
                } else if (ch == 'f' && i <= line.length() - 3) {
                    if (i > 0 && Character.isLetter(line.charAt(i - 1))) continue;
                    if (i <= line.length() - 4 && Character.isLetter(line.charAt(i + 3))) continue;
                    forFlag = true;
                }
            }
            if (flag && deque.size() == 0L) {
                break;
            }
        }
        scanner.close();
        System.out.println(maxSize);
    }
}
