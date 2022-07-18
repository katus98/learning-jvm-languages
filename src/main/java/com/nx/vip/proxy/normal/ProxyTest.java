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
public class ProxyTest {
    @Test
    void test() {
        IHello hello = new Hello();
        InvocationHandler helloHandler = new ProxyHandler(hello);
        // 通过传入的参数动态产生一个类, 动态产生内容, 然后动态生成字节码文件
        // 参数1: 类加载器
        // 参数2: 需要实现的接口
        // 参数3: 指导所有需要实现的方法如何实现, 通过反射的方式
        IHello iHello = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), helloHandler);
        iHello.hello();
        System.out.println("---------------");
        // 这里需要注意一个事情: 代理方法只有通过代理类显式调用才能生效, 内部调用都不会生效, 而且只有一层, 不会递归
        iHello.outerHello();
    }
}
