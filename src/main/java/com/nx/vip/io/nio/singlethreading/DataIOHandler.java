package com.nx.vip.io.nio.singlethreading;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Read事件绑定DataIOHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class DataIOHandler implements Runnable {
    private final SelectionKey sk;
    private final SocketChannel sc;
    /**
     * 状态: 0 读取, 1 写入
     */
    int state;

    public DataIOHandler(SelectionKey sk, SocketChannel sc) {
        this.sk = sk;
        this.sc = sc;
        state = 0;    // 初始状态为读取
    }

    @Override
    public void run() {
        try {
            if (state == 0){
                read();
            } else{
                send();
            }
        } catch (IOException e) {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
        }
    }

    private void closeChannel() {
        try {
            sk.cancel();
            sc.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private synchronized void read() throws IOException {
        // NIO不可用Readers, 因为Readers不支持非阻塞
        byte[] arr = new byte[1024];
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        int numBytes = sc.read(buffer);
        if (numBytes == -1) {
            System.out.println("[Warning!] client [" + sc.getRemoteAddress().toString() + "] has been closed.");
            closeChannel();
            return;
        }
        // 将读取到的数据转化为字符串
        String str = new String(arr);
        if (!str.equals(" ")) {
            System.out.println(sc.getRemoteAddress().toString() + " > " + str);
            // 字符串处理逻辑
            process(str);
            // 切换读写状态
            state = 1;
            // 通过socket key改变select监听器需要监听的事件, 从读变成写
            sk.interestOps(SelectionKey.OP_WRITE);
            // 让阻塞的select监听器立刻返回
            // 个人理解因为select监听器上注册的监听事件发生了改变, 而已经阻塞的select底层调用不会自动变更, 需要放行之后重新执行, 让修改生效
            sk.selector().wakeup();
        }
    }

    private void send() throws IOException {
        String str = "Your message has sent to " + sc.socket().getLocalSocketAddress().toString() + ".\r\n";
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        // 将缓冲区的内容写出到通信socket中
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        // 切换读写状态
        state = 0;
        // 通过socket key改变select监听器需要监听的事件, 从写变成读
        sk.interestOps(SelectionKey.OP_READ);
        // 让阻塞的select监听器立刻返回
        // 个人理解因为select监听器上注册的监听事件发生了改变, 而已经阻塞的select底层调用不会自动变更, 需要放行之后重新执行, 让修改生效
        sk.selector().wakeup();
    }

    void process(String str) {
        // 解码
        // 业务逻辑
        // 编码
        System.out.println("Process: " + str + "...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}