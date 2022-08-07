package com.leetcode.exam.autumn.formal.mhy;

import java.util.Scanner;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            String xwLine = scanner.nextLine();
            String qjLine = scanner.nextLine();
            BeatHandler beatHandler = new BeatHandler(new XiErWei(xwLine), new QiJie(qjLine));
            beatHandler.beat();
        }
        scanner.close();
        for (int i = 0; i < times; i++) {
            System.out.println("I love V2V forever!");
        }
    }

    public static class XiErWei {
        int life, attack, defend, speed;
        int cd = 2;

        public XiErWei(String line) {
            String[] items = line.split(" ");
            this.life = Integer.parseInt(items[0]);
            this.attack = Integer.parseInt(items[1]);
            this.defend = Integer.parseInt(items[2]);
            this.speed = Integer.parseInt(items[3]);
        }
    }

    public static class QiJie {
        int life, attack, defend, speed;
        int cd = 2;

        public QiJie(String line) {
            String[] items = line.split(" ");
            this.life = Integer.parseInt(items[0]);
            this.attack = Integer.parseInt(items[1]);
            this.defend = Integer.parseInt(items[2]);
            this.speed = Integer.parseInt(items[3]);
        }
    }

    private static class BeatHandler {
        private final XiErWei xiErWei;
        private final QiJie qiJie;

        public BeatHandler(XiErWei xiErWei, QiJie qiJie) {
            this.xiErWei = xiErWei;
            this.qiJie = qiJie;
        }

        public void beat() {
        }
    }
}
