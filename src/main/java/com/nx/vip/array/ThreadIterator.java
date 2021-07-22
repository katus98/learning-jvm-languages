package com.nx.vip.array;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
@AllArgsConstructor
public class ThreadIterator extends Thread {
    private final List<Integer> list;

    @Override
    public void run() {
        Iterator<Integer> it = list.iterator();
        while (true) {
            while (it.hasNext()) {
                it.next();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
