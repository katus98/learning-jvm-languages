package com.katus.enumAnnotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
@MyAnnotations({@MyAnnotation(value = "hello"), @MyAnnotation(value = "hi")})
public class AnnotationTest {
    @Test
    public void test1() {
        // JavaSE 5.0 之后自带的注解 @Override @Deprecated @SuppressWarnings("")
        @SuppressWarnings("unused")
        int num = 0;

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show() {
        System.out.println("Nothing");
    }

    @Test
    public void test2() {
        Annotation[] annotations = AnnotationTest.class.getAnnotations();   // 只能获取到运行时保留的注解
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

class Generic {
    public void test() {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}
