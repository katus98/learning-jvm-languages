package com.nx.vip.anno.inherited;

import org.junit.jupiter.api.Test;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class InheritedTest {

    static class InheritedParent {
    }

    static class InheritedChild extends InheritedParent {
    }

    @InheritedAnnotation
    static class Parent {
    }

    static class Child extends Parent {
    }

    @Test
    void test() {
        System.out.println(InheritedChild.class.getAnnotation(InheritedAnnotation.class));
        System.out.println(Child.class.getAnnotation(InheritedAnnotation.class));
    }
}
