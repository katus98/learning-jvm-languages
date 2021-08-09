package com.nx.vip.proxy.normal;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理调用
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class ProxyMain {
    @Test
    void test() {
        IHello hello = new Hello();
        InvocationHandler helloHandler = new ProxyHandler(hello);
        IHello iHello = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), helloHandler);
        iHello.hello();
    }
}
