package com.nx.vip.io.socket;

import com.nx.util.MyLog;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO的阻塞在哪里?
 * * accept会阻塞, read也会阻塞
 * 阻塞带来的问题?
 * * 单线程无法处理并发连接
 * * 如果一个客户端建立了连接却没有发送数据, 服务器端就会阻塞, 导致无法应答其他连接
 * * 解决方法 多线程
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 8080));
        while (true) {
            MyLog.info("stand by!");
            // 监听有没有连接, 会阻塞
            Socket socket = serverSocket.accept();
            // 获取数据, 也会阻塞
            InputStream is = socket.getInputStream();
            int size = is.read(buffer);
            String content = new String(buffer);
            MyLog.info(content);
            socket.close();
        }
    }
}
