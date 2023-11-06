package cn.xiaotian.concurrency.multi_thread;

/**
 * @author xiaotian
 * @description 死锁
 * @date 2023-02-27 10:36
 */
public class DeadThread {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(
                () -> {
                    synchronized (lock1) {
                        System.out.println("thread1 获得lock1");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2) {
                            System.out.println("thread1 获得lock2");
                        }
                    }
                    System.out.println("thread1 end");
                }
        ).start();

        new Thread(
                () -> {
                    synchronized (lock2) {
                        System.out.println("thread2 获得lock2");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock1) {
                            System.out.println("thread2 获得lock1");
                        }
                    }
                    System.out.println("thread1 end");
                }
        ).start();
    }
}
