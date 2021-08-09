package com.nx.vip.anno.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {
    String value() default "hello";
}
