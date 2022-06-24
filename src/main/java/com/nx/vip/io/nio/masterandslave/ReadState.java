package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 读取状态逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class ReadState implements HandlerState {
    private SelectionKey sk;

    public ReadState() {
    }

    @Override
    public void changeState(DataIOHandler h) {
        h.setState(new WriteState());
    }

    @Override
    public void handle(DataIOHandler h, SelectionKey sk, SocketChannel sc, ThreadPoolExecutor pool) throws IOException {
        this.sk = sk;
        byte[] arr = new byte[1024];
        ByteBuffer buf = ByteBuffer.wrap(arr);
        int numBytes = sc.read(buf);
        if (numBytes == -1) {
            System.out.println("[Warning!] A client has been closed.");
            h.closeChannel();
            return;
        }
        String str = new String(arr);
        if (!str.equals(" ")) {
            System.out.println(sc.socket().getRemoteSocketAddress().toString() + " > " + str);
            pool.execute(new WorkerThread(h, str));
        }
    }

    synchronized void process(DataIOHandler h, String str) {
        // decode
        // process
        System.out.println("Process: " + str);
        // encode
        changeState(h);
        this.sk.interestOps(SelectionKey.OP_WRITE);
        this.sk.selector().wakeup();
    }

    class WorkerThread implements Runnable {
        private final DataIOHandler h;
        private final String str;

        public WorkerThread(DataIOHandler h, String str) {
            this.h = h;
            this.str = str;
        }

        @Override
        public void run() {
            process(h, str);
        }
    }
}