package com.nx.vip.anno.inherited;

import java.lang.annotation.*;

/**
 * Inherited注解修饰的注解可以由被修饰的子类继承到,
 * 即通过子类可以获取到父类上的注释
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface InheritedAnnotation {
}
