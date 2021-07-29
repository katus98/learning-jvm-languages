package com.nx.vip.anno;

import lombok.ToString;

/**
 * 注解三个作用
 * 1、编译检查
 * 2、生成文档
 * 3、代码分析
 *
 * @author SUN Katus
 * @version 1.0
 * @since jdk8
 */
@ToString
public class NxUser {
    private int id;
    private String name;

    /**
     * @param a 加数一
     * @param b 加数二
     * @return 返回两个加数的和
     */
    public int add(int a, int b) {
        return a + b;
    }
}
