package com.nx.vip.anno;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public @interface MyAnno2 {
    /**
     * 特殊的属性, 注解中只有一个特殊的属性, 属性名是value的
     * 使用时可以不写 value=, 直接写value的值
     */
    String value();
}
