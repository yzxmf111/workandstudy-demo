package cn.xiaotian.concurrency.multi_thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author xiaotian
 * @description 线程池中一个线程执行失败，其他的线程停止执行 or 主线程停止执行
 * @date 2024-04-20 19:03
 */
public class ThreadPoolThreadStop {

    private static volatile CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        // 创建并启动线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }

        // 等待计数器为0，即有线程任务失败
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 终止其他线程的执行
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                // 执行任务...
                if (/* 某种失败条件 */false) {
                    System.out.println("Task failed, notifying other threads...");
                    latch.countDown(); // 通知其他线程任务失败
                    System.out.println(latch.getCount());
                    return; // 如果任务失败，直接返回
                }
                // 继续执行其他任务...
            } catch (Exception e) {
                System.out.println("Task failed, notifying other threads...");
                latch.countDown(); // 通知其他线程任务失败
                e.printStackTrace();
            }
        }
    }

}
