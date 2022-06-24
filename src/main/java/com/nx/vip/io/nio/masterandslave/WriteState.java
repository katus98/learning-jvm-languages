package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 写出状态逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class WriteState implements HandlerState {
    public WriteState() {
    }

    @Override
    public void changeState(DataIOHandler h) {
        h.setState(new ReadState());
    }

    @Override
    public void handle(DataIOHandler h, SelectionKey sk, SocketChannel sc, ThreadPoolExecutor pool) throws IOException {
        String str = "Your message has sent to " + sc.getLocalAddress().toString() + "\r\n";
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        changeState(h);
        sk.interestOps(SelectionKey.OP_READ);
        sk.selector().wakeup();
    }
}