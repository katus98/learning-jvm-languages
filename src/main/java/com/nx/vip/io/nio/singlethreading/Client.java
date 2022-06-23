package com.nx.vip.io.nio.singlethreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class Client {

    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 1333;
        try {
            Socket client = new Socket(hostname, port);
            System.out.println("连接至目的地: " + hostname);
            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = stdIn.readLine()) != null) { // 讀取輸入
                out.println(input);
                out.flush();
                if (input.equals("exit")) {
                    break;
                }
                System.out.println("server: " + in.readLine());
            }
            client.close();
            System.out.println("client stop.");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + hostname);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the socket connection");
        }
    }
}
