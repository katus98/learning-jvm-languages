package com.katus.thread;

/**
 * 线程通信
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
/*
* notify() notifyAll() wait() 只能用在同步方法和同步代码块中
* 三个方法的调用者必须是当前同步代码块或者同步方法的同步监视器
* 三个方法是定义在Object类中的 所有的对象均有资格调用
* */
class NumberPainter implements Runnable {
    private int number;

    public NumberPainter() {
        this(0);
    }

    public NumberPainter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 一旦执行此方法 会有一个wait中的阻塞线程被唤醒(选取其中优先级高的线程)
                notify();   // this.notify();
                // 一旦执行此方法 全部wait中的阻塞线程被唤醒
                // notifyAll();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number++);
                } else {
                    break;
                }
                try {
                    // 一旦执行此方法 本线程立刻阻塞 同时释放同步监视器
                    wait();   // this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadCommunicationTest {
    public static void main(String[] args) {
        NumberPainter numberPainter = new NumberPainter();
        Thread t1 = new Thread(numberPainter), t2 = new Thread(numberPainter);

        t1.start();
        t2.start();
    }
}
