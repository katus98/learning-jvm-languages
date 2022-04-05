package com.leetcode.other.thread;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-04-05
 */
public class PrintNumber {
    private static int threadIndex = 0;
    private static volatile int number = 0;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            new Thread(new MyTask(i, num)).start();
        }
    }

    public static class MyTask implements Runnable {
        private final int i;
        private final int count;

        public MyTask(int i, int count) {
            this.i = i;
            this.count = count;
        }

        @Override
        public void run() {
            while (number <= 100) {
                if (threadIndex % count == i) {
                    synchronized (LOCK) {
                        System.out.println("thread " + i + ": " + number);
                        number++;
                        threadIndex++;
                    }
                }
            }
        }
    }
}
