package com.nx.vip.proxy.cglib;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class Dog implements IAnimal {
    @Override
    public final void run(String name) {
        System.out.println("Dog" + name + "----run");
    }

    @Override
    public void eat() {
        System.out.println("Dog----eat");
    }
}
