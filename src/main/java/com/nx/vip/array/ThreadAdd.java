package com.nx.vip.array;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
@AllArgsConstructor
public class ThreadAdd extends Thread {
    private final List<Integer> list;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("循环执行: " + i);
            list.add(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
