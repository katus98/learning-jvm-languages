package com.nx.vip.io.nio.singlethreading;

import java.io.IOException;

/**
 * Reactor单线程模型启动器
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class SingleThreadingReactor {

    public static void main(String[] args) throws IOException {
//        Selector abstractSelector = SelectorProvider.provider().openSelector();
//        ServerSocketChannel serverSocketChannel = SelectorProvider.provider().openServerSocketChannel();
//        System.out.println(abstractSelector.selectNow());
        try {
            ReactorServer reactor = new ReactorServer(1333);
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}