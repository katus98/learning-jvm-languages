package com.nx.vip.anno;

import java.util.Date;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class AnnotationDemo01 {
    /**
     * Deprecated注释修饰的内容表示已经弃用, 不建议使用
     */
    @Deprecated
    public void show01() {
        System.out.println("nx nx...");
    }

    @MyAnno(showStrArr = {"hello", "nx"}, showEnum = ColorEnum.BlACk, showAnno = @MyAnno2("samuel"))
    public void show02() {
        System.out.println("nx nx nx...");
    }
}

/**
 * 压制警告
 */
@SuppressWarnings("all")
class Demo {
    public static void main(String[] args) {
        AnnotationDemo01 annotationDemo01 = new AnnotationDemo01();
        annotationDemo01.show02();
        Date date = new Date();
        date.getDate();
    }
}

/**
 * 函数式接口, 内部只能含有一个抽象方法
 * 可以使用lambda表达式
 */
@FunctionalInterface
interface FunctionInterface {
    String show01();

    default void sayHi() {
    }
}
