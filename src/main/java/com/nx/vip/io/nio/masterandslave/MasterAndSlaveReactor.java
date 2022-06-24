package com.nx.vip.io.nio.masterandslave;

import java.io.IOException;

/**
 * Reactor主从多线程模型启动器
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class MasterAndSlaveReactor {

    public static void main(String[] args) {
        try {
            MasterReactor reactor = new MasterReactor(1333);
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}