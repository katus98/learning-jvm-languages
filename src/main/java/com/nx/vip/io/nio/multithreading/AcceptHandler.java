package com.nx.vip.io.nio.multithreading;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Accept事件绑定的处理逻辑
 * * 接受并生成通信socket
 * * 将通信socket绑定到select监听器上
 * * 为Read事件绑定DataIOHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class AcceptHandler implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;

    public AcceptHandler(Selector selector, ServerSocketChannel ssc) {
        this.ssc = ssc;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                System.out.println(sc.getRemoteAddress().toString() + " is connected.");
                sc.configureBlocking(false);
                SelectionKey sk = sc.register(selector, SelectionKey.OP_READ);
                sk.attach(new DataIOHandler(sk, sc));
                selector.wakeup();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}