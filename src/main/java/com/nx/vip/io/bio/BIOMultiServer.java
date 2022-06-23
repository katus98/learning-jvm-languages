package com.nx.vip.io.bio;

import com.nx.util.MyLog;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO多线程服务端实现
 * 如果要实现并发需要客户端实现多线程
 * 每一个客户端的连接都单独开一个线程去应答
 * 会有很多线程始终处于阻塞状态无法恢复(客户端不发数据, 堵塞read), 造成资源浪费
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class BIOMultiServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 8080));
        while (true) {
            MyLog.info("stand by!");
            // 监听有没有连接, 会阻塞
            Socket socket = serverSocket.accept();
            executorService.submit(new Task(socket));
        }
    }

    public static class Task implements Runnable {
        private final Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 获取数据, 也会阻塞
            InputStream is;
            try {
                is = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int size = is.read(buffer);
                String content = new String(buffer);
                MyLog.info(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
