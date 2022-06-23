package com.nx.vip.io.nio.singlethreading;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Accept事件绑定的处理逻辑
 * * 接受并生成通信socket
 * * 将通信socket绑定到select监听器上
 * * 为Read事件绑定TCPHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class ClientConnectionAcceptor implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;

    public ClientConnectionAcceptor(Selector selector, ServerSocketChannel ssc) {
        this.ssc = ssc;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            // 接受客户端连接请求
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                System.out.println(sc.socket().getRemoteSocketAddress().toString() + " is connected.");
                // 设置非阻塞
                sc.configureBlocking(false);
                // 将与客户端通信的socket注册到select监听器上, 监听事件为读取事件OP_READ
                SelectionKey sk = sc.register(selector, SelectionKey.OP_READ);
                // 让阻塞的selector立即返回 (本方法提前执行也可生效)
                selector.wakeup();
                // 为服务器与客户端通信socket的监听事件绑定一个处理逻辑
                sk.attach(new DataTransmissionHandler(sk, sc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}