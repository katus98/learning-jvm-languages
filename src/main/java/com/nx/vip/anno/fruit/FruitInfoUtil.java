package com.nx.vip.anno.fruit;

import java.lang.reflect.Field;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class FruitInfoUtil {

    public static void getInfo(Class<Apple> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("水果名称" + fruitName.value());
            }
        }
    }
}
