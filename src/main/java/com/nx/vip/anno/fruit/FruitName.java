package com.nx.vip.anno.fruit;

import java.lang.annotation.*;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {

    String value();
}
