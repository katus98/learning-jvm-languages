package com.nx.vip.reflection.basic;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * 反射比较灵活, 但是效率比较低
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@Data
public class Person {
    private String name;

    static {
        System.out.println("ha...");
    }

    public void study() {
        System.out.println("good good study day day up...");
    }

    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class<Person> clazz = Person.class;
        // 获得类的结构
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getName());

        // 动态创建对象
        Person person = clazz.newInstance();

        // 调用方法
        Method studyMethod = clazz.getDeclaredMethod("study");
        studyMethod.invoke(person);
    }
}
