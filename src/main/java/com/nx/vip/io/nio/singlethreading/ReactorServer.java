package com.nx.vip.io.nio.singlethreading;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor模型服务端
 * * 开启服务端监听socket
 * * 开启select监听器
 * * 将服务器监听socket注册到select监听器上
 * * 为Accept事件绑定AcceptHandler处理逻辑
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class ReactorServer implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;   // 对应一个线程

    public ReactorServer(int port) throws IOException {
        // 另一种写法
//        Selector abstractSelector = SelectorProvider.provider().openSelector();
//        ServerSocketChannel serverSocketChannel = SelectorProvider.provider().openServerSocketChannel();
        // 打开一个select监听器
        this.selector = Selector.open();
        // 打开服务器监听socket
        this.ssc = ServerSocketChannel.open();
        // 设置服务器监听socket为非阻塞
        ssc.configureBlocking(false);
        // 设置IP地址和端口号
        InetSocketAddress address = new InetSocketAddress(port);
        // 服务器信道绑定IP和端口
        ssc.socket().bind(address);
        // 将服务器监听socket注册到select监听器, 监听事件为接收事件OP_ACCEPT
        SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 为服务器监听socket的监听事件绑定一个处理逻辑
        sk.attach(new AcceptHandler(selector, ssc));
    }

    // 判断你是否发生了空轮训--->1s 512
    @Override
    public void run() {
        System.out.println("Waiting for new event on port: " + ssc.socket().getLocalPort() + "...");
        while (!Thread.interrupted()) {   // 在线程被中段前持续进行
            try {
//                selector.select(2000);   // 最多阻塞两秒
//                selector.selectNow();   // 立马返回, 不会阻塞
                if (selector.select() == 0) {   // 阻塞
                    Thread.sleep(100);
                    continue;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            // 获取监听到事件的socket的key集合
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectedKeys.iterator();
            // 遍历集合
            while (it.hasNext()) {
                // 每个监听到事件的socket都去执行自己绑定的额外逻辑
                dispatch((it.next()));
                // 移除元素
                // 这个移除是因为selector.selectedKeys()返回的事件集合不会自己清除
                // 如果不移除处理过的事件, 第二次调用的时候这个事件还会在集合里面, 即使实际上没有发生
                it.remove();
            }
        }
    }

    private void dispatch(SelectionKey key) {
        // 获取当前socket key绑定的处理逻辑并执行
        Runnable r = (Runnable) key.attachment();
        if (r != null) {
            r.run();
        }
    }
}