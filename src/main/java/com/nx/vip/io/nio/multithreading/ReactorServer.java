package com.nx.vip.io.nio.multithreading;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor模型服务端
 * * 开启服务端监听socket
 * * 开启select监听器
 * * 将服务器监听socket注册到select监听器上
 * * 为Accept事件绑定AcceptHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class ReactorServer implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;

    public ReactorServer(int port) throws IOException {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        ssc.socket().bind(address);
        ssc.configureBlocking(false);
        // 在注册监听事件的同时绑定处理逻辑
        ssc.register(selector, SelectionKey.OP_ACCEPT, new AcceptHandler(selector, ssc));
    }

    @Override
    public void run() {
        System.out.println("Waiting for new event on port: " + ssc.socket().getLocalPort() + "...");
        while (!Thread.interrupted()) {
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

    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) key.attachment();
        if (r != null) {
            r.run();
        }
    }
}