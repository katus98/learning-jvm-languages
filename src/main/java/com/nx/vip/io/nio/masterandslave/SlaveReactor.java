package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor模型服务端 负责通信事件
 * * 监听通信事件, 调用IO绑定逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class SlaveReactor implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;
    /**
     * 是否暂停处理
     */
    private volatile boolean restart = false;
    /**
     * 多路复用器ID
     */
    private final int num;

    public SlaveReactor(Selector selector, ServerSocketChannel ssc, int num) {
        this.ssc = ssc;
        this.selector = selector;
        this.num = num;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Selector " + num + " Waiting for restart...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!Thread.interrupted() && !restart) {
                try {
                    if (selector.select() == 0) continue;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                while (it.hasNext()) {
                    dispatch(it.next());
                    it.remove();
                }
            }
        }
    }

    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) key.attachment();
        if (r != null) {
            r.run();
        }
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }
}