package com.nx.vip.io.nio.multithreading;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 处理状态接口
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public interface HandlerState {

    void changeState(DataIOHandler h);

    void handle(DataIOHandler h, SelectionKey sk, SocketChannel sc, ThreadPoolExecutor pool) throws IOException;
}