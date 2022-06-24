package com.nx.vip.io.nio.multithreading;

import java.io.IOException;

/**
 * Reactor多线程模型启动器
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class MultiThreadingReactor {

    public static void main(String[] args) {
        try {
            ReactorServer reactor = new ReactorServer(1333);
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}