package com.nx.vip.generic.type;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型不影响实际的数据类型
 * 泛型只在编译阶段期作用，在编译之后程序会采取去泛型化的处理
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class GenType {

    @Test
    public void method01() {
        List list = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        System.out.println(list.getClass());
        System.out.println(strList.getClass());
        System.out.println(list.getClass() == strList.getClass()); // true
    }

    @Test
    public void method02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> strList = new ArrayList<>();
        strList.add("q");
        strList.add("nx");
//        strList.add(new Object());
        System.out.println(strList.size());
        System.out.println("--------------------");
        Class<? extends List> clazz = strList.getClass();
        Method addMeth = clazz.getDeclaredMethod("add", Object.class);
        addMeth.invoke(strList, new Object());

        System.out.println(strList.size());
    }
}
