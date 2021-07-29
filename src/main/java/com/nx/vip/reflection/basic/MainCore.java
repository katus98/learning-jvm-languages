package com.nx.vip.reflection.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 获取Class文件的方式
 * 1、类名.class
 * 2、Class.forName(name)
 * 3、对象.getClass()
 * 4、通过类加载器.loadClass()
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class MainCore {

    public static void main(String[] args) throws Exception {
        // 不会类初始化
        Class<Person> clazz01 = Person.class;
        System.out.println(clazz01);
        // 反射 类初始化
        Class<?> clazz02 = Class.forName("com.nx.vip.reflection.basic.Person");
        System.out.println(clazz02);
        // 类初始化
        Class<? extends Person> clazz03 = new Person().getClass();
        System.out.println(clazz03);
        // 类初始化
        Class<?> clazz04 = MainCore.class.getClassLoader().loadClass("com.nx.vip.reflection.basic.Person");
        System.out.println(clazz04);

        // 通过clazz获取基本信息；属性信息；方法信息；注解信息
        // 获取的是类的修饰符
        System.out.println("--------------");
        int modifiers = clazz01.getModifiers();
        System.out.println(modifiers);
        System.out.println(clazz01.getPackage());
        System.out.println(clazz01.getName());
        System.out.println(clazz01.getSimpleName());
        System.out.println(clazz01.getClassLoader());
        System.out.println(Arrays.toString(clazz01.getInterfaces()));
        System.out.println(clazz01.getSuperclass());
        System.out.println(Arrays.toString(clazz01.getAnnotations()));

        // 属性基本操作
        System.out.println("--------------");
        Class<User> clazz = User.class;
        User user = clazz.newInstance(); // 反射调用的无参的构造方法, 而且需要可见

        Field[] fields = clazz.getFields(); // 所有public字段 包括继承来的
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("--------------");
        Field[] declaredFields = clazz.getDeclaredFields(); // 获取当前类中定义的字段, 包括各种权限的
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        System.out.println("--------------");
        Field addField = clazz.getDeclaredField("address");
        addField.setAccessible(true); // 设置字段的强制访问
        addField.set(user, "北京西三旗奈学");
        System.out.println(user.getAddress());
        System.out.println("--------------");

        Field nationality = clazz.getDeclaredField("nationality");
        nationality.set(null, "中国");
        System.out.println(User.nationality);
        System.out.println("--------------");
        // 构造方法
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        Constructor<User> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        declaredConstructor.setAccessible(true);
        User user1 = declaredConstructor.newInstance("idCard", "address");
        System.out.println(user1);
    }
}
