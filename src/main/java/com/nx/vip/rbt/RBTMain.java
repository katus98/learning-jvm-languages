package com.nx.vip.rbt;

import org.junit.jupiter.api.Test;

/**
 * 左倾红黑树测试
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
public class RBTMain {
    @Test
    void test() {
        RBT<Integer> rbt = new RBT<>();
        rbt.addEle(42);
        rbt.addEle(37);
        rbt.addEle(12);
        rbt.addEle(7);
        rbt.addEle(8);
        rbt.levelOrder();
    }
}
