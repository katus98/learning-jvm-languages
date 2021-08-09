package com.nx.vip.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class CglibMain {
    @Test
    void test() {
        // 创建Enhancer对象, 类似于JDK动态代理的Proxy类, 下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(Dog.class);
        // 设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        // 这里的creat方法就是正式创建代理类
        IAnimal proxyAnimal = (IAnimal) enhancer.create();
        // 调用代理类的eat方法
        proxyAnimal.eat();
        // run方法是final不可重载, 因此也无法代理
        proxyAnimal.run("123");
    }
}
