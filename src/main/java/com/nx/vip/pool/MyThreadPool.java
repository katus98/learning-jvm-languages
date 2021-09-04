package com.nx.vip.pool;

import com.nx.util.MyLog;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SUN Katus
 * @version 1.0, 2021-09-04
 */
public class MyThreadPool {
    // 最大的同时运行线程数量
    private int threadNumber;
    // 当前正在运行中的线程
    private HashSet<Worker> workers = new HashSet<>();
    // 等待分配的任务队列
    private TaskQueue tasks;
    private long timeout;
    private final AtomicInteger number = new AtomicInteger(0);

    public MyThreadPool(int threadNumber, int queueSize) {
        this.threadNumber = threadNumber;
        this.tasks = new TaskQueue(queueSize);
        this.timeout = 0L;
    }

    public MyThreadPool(int threadNumber, int queueSize, long timeout) {
        this.threadNumber = threadNumber;
        this.tasks = new TaskQueue(queueSize);
        this.timeout = timeout;
    }

    public void execute(Task task) {
        if (workers.size() < threadNumber) {
            MyLog.info("任务未满, 立刻启动新线程运行: " + task);
            Worker worker = new Worker(task);
            workers.add(worker);
            worker.start();
        } else {
            MyLog.info("线程已满, 进入队列等候: " + task);
            tasks.offer(task);
        }
    }

    public class Worker implements Runnable {
        private Thread thread;
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.runnable = runnable;
            this.thread = new Thread(this, "worker" + number.incrementAndGet());
        }

        @Override
        public void run() {
            while (runnable != null) {
                runnable.run();
                runnable = timeout == 0L ? tasks.take() : tasks.poll(timeout);
            }
        }

        public void start() {
            thread.start();
        }
    }

    public static class TaskQueue {
        private final ReentrantLock lock = new ReentrantLock();
        // 生产者线程
        private final Condition full = lock.newCondition();
        // 消费者线程
        private final Condition empty = lock.newCondition();
        private Deque<Task> tasks = new ArrayDeque<>();
        private int queueSize;

        public TaskQueue(int queueSize) {
            this.queueSize = queueSize;
        }

        public void offer(Task task) {
            lock.lock();
            try {
                while (tasks.size() == queueSize) {
                    MyLog.info("队列已满");
                    full.await();
                }
                tasks.addLast(task);
                empty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public Task take() {
            lock.lock();
            Task task = null;
            try {
                while (tasks.size() == 0) {
                    MyLog.info("队列已空, 不再弹出, 永久阻塞");
                    empty.await();
                }
                task = tasks.removeFirst();
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return task;
        }

        public Task poll(long nanos) {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Task task = null;
            try {
                while (tasks.size() == 0) {
                    MyLog.info("队列已空, 不再弹出, 超时阻塞");
                    nanos = empty.awaitNanos(nanos);
                }
                task = tasks.removeFirst();
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return task;
        }
    }

    @AllArgsConstructor
    @ToString
    public static class Task implements Runnable {
        private String name;

        @Override
        public void run() {
            MyLog.info(name + ": 临界区执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 1, 100L);
        for (int i = 1; i <= 10; i++) {
            myThreadPool.execute(new Task("task" + i));
        }
    }
}
