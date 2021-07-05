package com.katus.enumAnnotation;

import java.lang.annotation.*;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
@Retention(RetentionPolicy.RUNTIME)   // 指定注解的生命周期 默认CLASS, 另有SOURCE RUNTIME
@Target({ElementType.TYPE, ElementType.METHOD})   // 指定注解可以修饰的程序元素
@Documented   // 表示注解会被javadoc解析 只是一个标记
@Inherited   // 注解具有继承性 修饰了父类 则子类必然具有
public @interface MyAnnotations {
    MyAnnotation[] value();
}
