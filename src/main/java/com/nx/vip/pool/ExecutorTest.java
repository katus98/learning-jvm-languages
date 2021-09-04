package com.nx.vip.pool;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SUN Katus
 * @version 1.0, 2021-09-04
 */
public class ExecutorTest {
    /**
     * Executors.newSingleThreadExecutor()
     * 最大线程数和核心线程数都是1, 等于单线程
     * 与Executors.newFixedThreadPool(1)区别在于永远无法改变线程数
     * 通过Thread运行多线程如果抛出异常则终止, 而这种方式不会, 会另启动一个线程继续后面的代码
     */
    @Test
    void singleThreadExecutor() {
        /*
         * 最大线程数和核心线程数都是1
         * 等于单线程
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            MyLog.info("start");
        });
        executorService.execute(() -> {
            MyLog.info("" + 1 / 0);
        });
        executorService.execute(() -> {
            MyLog.info("end");
        });
    }

    /**
     * Executors.newCachedThreadPool()
     * 缓存
     * 没有核心线程 60s之后如果没有任务 那么线程池里面的线程全部死亡
     * 空闲线程10000个
     * 同步阻塞队列
     * 适用于任务运行快, 但是任务很多, 可以节省资源
     */
    @Test
    void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    /**
     * Executors.newFixedThreadPool(10)
     * 固定线程池, 默认核心线程数和最大线程数一致
     */
    @Test
    void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
