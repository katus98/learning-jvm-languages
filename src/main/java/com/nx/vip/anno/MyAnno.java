package com.nx.vip.anno;

import java.lang.annotation.*;

/**
 * 接口的本质就是实现了 java.lang.annotation.Annotation 接口的接口
 * 既然是接口就可以定义方法, 注解中定义的方法叫做 属性
 * 属性的返回结果必须是String, 基本数据类型, Enum, Class, 注解类型, 以及以上类型的数组类型
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@Documented // Javadoc
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // source<class, runtime>
@Inherited // 是否允许被子类继承
public @interface MyAnno {

    int showInt() default 10;

    String[] showStrArr();

    ColorEnum showEnum();

    MyAnno2 showAnno();

//    Class showClass();
}
