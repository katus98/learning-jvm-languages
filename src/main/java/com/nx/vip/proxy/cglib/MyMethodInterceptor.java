package com.nx.vip.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("After invoke");
        return result;
    }
}
