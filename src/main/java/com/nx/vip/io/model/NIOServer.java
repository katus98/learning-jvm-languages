package com.nx.vip.io.model;

import com.nx.util.MyLog;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * NIO
 * 一个非常简易的Java实现
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class NIOServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 用于存放历史连接
        List<SocketChannel> list = new ArrayList<>();
        // 存放数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // NIO
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定主机和端口
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
        MyLog.info("server start!");
        while (true) {
            // 此处非阻塞
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                list.add(socketChannel);
                // 设置通信socket非阻塞
                socketChannel.configureBlocking(false);
                MyLog.info("new connection!");
            } else {
                TimeUnit.SECONDS.sleep(3);
                MyLog.info("no connection!");
            }
            // 遍历历史连接, 读取数据 (实际可以通过操作系统层面实现, 这个地方只是一个效率很低的实现)
            // 操作系统层面对所有socket的轮询实际上就是select的功能
            for (SocketChannel channel : list) {
                // 读取数据非阻塞
                int size = channel.read(buffer);
                if (size > 0) {
                    buffer.flip();
                    byte[] buf = new byte[buffer.remaining()];
                    buffer.get(buf);
                    String content = new String(buf);
                    MyLog.info("content: " + content);
                    buffer.clear();
                }
            }
        }
    }
}
