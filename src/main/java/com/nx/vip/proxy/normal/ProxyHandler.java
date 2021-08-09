package com.nx.vip.proxy.normal;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理处理器
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
@RequiredArgsConstructor
public class ProxyHandler implements InvocationHandler {
    private final Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke: " + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("After invoke: " + method.getName());
        return result;
    }
}
