package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DataIOHandler处理逻辑
 * * 多线程执行process部分
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class DataIOHandler implements Runnable {
    private final SelectionKey sk;
    private final SocketChannel sc;
    private static final int THREAD_COUNTING;
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    private HandlerState state;

    static {
        THREAD_COUNTING = 10;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
                THREAD_COUNTING, THREAD_COUNTING, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        THREAD_POOL_EXECUTOR.setMaximumPoolSize(32);
    }

    public DataIOHandler(SelectionKey sk, SocketChannel sc) {
        this.sk = sk;
        this.sc = sc;
        this.state = new ReadState();
    }

    @Override
    public void run() {
        try {
            state.handle(this, sk, sc, THREAD_POOL_EXECUTOR);
        } catch (IOException e) {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
        }
    }

    public void closeChannel() {
        try {
            sk.cancel();
            sc.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void setState(HandlerState state) {
        this.state = state;
    }
}