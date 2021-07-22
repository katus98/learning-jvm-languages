package com.nx.vip.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
public class ArrayListDemo {
    /**
     * failFast 机制
     * 创建迭代器对象时 将全局的modCount赋值给迭代器的局部变量expectedModCount
     * 在迭代的过程中modCount != expectedModCount快速抛出异常
     * 存疑: 运行时异常对多线程的终止效果及其原理
     */
    @Test
    void failFast() {
        List<Integer> list = new ArrayList<>();
        new ThreadIterator(list).start();
        new ThreadAdd(list).start();
    }

    /**
     * Collections.synchronizedList() 方法可以为我们返回同步的集合, 切记使用返回值
     * 实际上就是在原来集合的基础上对所有的访问方法套上一层同步代码块的壳 (挺垃圾的)
     * 但是由于返回的同步集合没有专属的迭代器和原有集合的 failFast 机制导致同步之后对下面的情况没什么效果
     */
    @Test
    void testSynchronizedList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        new ThreadIterator(synchronizedList).start();
        new ThreadAdd(synchronizedList).start();
    }
}
