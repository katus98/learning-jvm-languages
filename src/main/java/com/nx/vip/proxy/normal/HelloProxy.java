package com.nx.vip.proxy.normal;

/**
 * 静态代理类
 *   持有实际类, 将实际类的实现隐藏在实现的接口中, 同时可以对方法前后进行包装
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class HelloProxy implements IHello {
    IHello hello = new Hello();

    @Override
    public void hello() {
        System.out.println("Sth. Before Hello");
        hello.hello();
        System.out.println("Sth. After Hello");
    }

    @Override
    public void outerHello() {
        System.out.println("Sth. Before outerHello");
        hello();
        System.out.println("Sth. After outerHello");
    }
}
