package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor模型服务端 负责连接事件
 * * 开启服务端监听socket
 * * 开启select监听器
 * * 将服务器监听socket注册到select监听器上
 * * 为Accept事件绑定AcceptHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class MasterReactor implements Runnable {
    private final ServerSocketChannel ssc;
    /**
     * 用来监听连接事件的专用多路复用器
     */
    private final Selector selector;

    public MasterReactor(int port) throws IOException {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT, new AcceptHandler(ssc));
        InetSocketAddress address = new InetSocketAddress(port);
        ssc.socket().bind(address);
    }

    @Override
    public void run() {
        System.out.println("mainReactor waiting for new event on port: " + ssc.socket().getLocalPort() + "...");
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