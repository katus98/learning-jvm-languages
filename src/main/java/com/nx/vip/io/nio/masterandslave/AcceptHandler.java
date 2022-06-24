package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Accept事件绑定的处理逻辑
 * * 持有通信Selector池和IO线程池
 * * 接受并生成通信socket
 * * 将通信socket绑定到可用的select监听器上
 * * 为Read事件绑定DataIOHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class AcceptHandler implements Runnable {
    private final ServerSocketChannel ssc;
    private final int cores = Runtime.getRuntime().availableProcessors();
    /**
     * 用来与客户端进行通信的多路复用器池
     */
    private final Selector[] selectors = new Selector[cores];
    /**
     * 当前可用的多路复用器索引号
     */
    private int presentId = 0;
    /**
     * 每个用来与客户端进行通信的多路复用器的监听操作
     */
    private final SlaveReactor[] slaves = new SlaveReactor[cores];
    private final Thread[] threads = new Thread[cores];

    public AcceptHandler(ServerSocketChannel ssc) throws IOException {
        this.ssc = ssc;
        // 创建多个子多路复用器和对应的运行线程
        for (int i = 0; i < cores; i++) {
            selectors[i] = Selector.open();
            slaves[i] = new SlaveReactor(selectors[i], ssc, i);
            threads[i] = new Thread(slaves[i]);
            threads[i].start();
        }
    }

    @Override
    public synchronized void run() {
        try {
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                System.out.println(sc.getRemoteAddress().toString() + " is connected.");
                sc.configureBlocking(false);
                // 暂停线程
                slaves[presentId].setRestart(true);
                selectors[presentId].wakeup();
                // 将新连接的客户端socket注册到当前的子多路复用器上
                SelectionKey sk = sc.register(selectors[presentId], SelectionKey.OP_READ);
                selectors[presentId].wakeup();
                // 重启线程
                slaves[presentId].setRestart(false);
                // 每个用来与客户端进行通信的多路复用器绑定操作逻辑
                sk.attach(new DataIOHandler(sk, sc));
                if (++presentId == cores) presentId = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}