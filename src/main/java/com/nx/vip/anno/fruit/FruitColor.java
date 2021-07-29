package com.nx.vip.anno.fruit;

import com.nx.vip.anno.ColorEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {

    ColorEnum fruitColor() default ColorEnum.RED;
}
