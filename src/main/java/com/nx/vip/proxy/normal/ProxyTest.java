package com.nx.vip.proxy.normal;

import org.junit.jupiter.api.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * 动态代理调用
 * * JDK动态代理的过程
 * * * 通过接口在内存中生成代理类(字节码内容), 代理类是Proxy子类
 * * * 通过类加载器将代理类加载到JVM中
 * * * 通过传入InvocationHandler实现类实例化产生代理对象
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class ProxyTest {
    @Test
    public void test() {
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

    @Test
    public void testPrinciple() throws IOException {
        String resource = Objects.requireNonNull(Test.class.getResource("/")).getPath();
        // 产生JDK动态代理的代理对象并写出到磁盘
        byte[] proxyContent = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IHello.class});
        File file = new File(resource, "$Proxy0.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(proxyContent);
        fos.flush();
        fos.close();
    }
}
