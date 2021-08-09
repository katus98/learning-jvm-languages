package com.nx.vip.proxy.normal;

/**
 * 实际类 (被代理类)
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class Hello implements IHello {
    @Override
    public void hello() {
        System.out.println("Hello: Hello!");
    }
}
