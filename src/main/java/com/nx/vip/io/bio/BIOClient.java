package com.nx.vip.io.bio;

import com.nx.util.MyLog;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * BIO简易客户端实现
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 8080));
        MyLog.info("connected!");
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes(StandardCharsets.UTF_8));
        socket.close();
    }
}
