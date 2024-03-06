package cn.xiaotian.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaotian
 * @description
 * @date 2023-05-24 18:00
 */
public class Test {

    private AtomicInteger i= new AtomicInteger(0);
    public static void main(String[] args) {
        Test test = new Test();
        //线程池：50个线程
        ExecutorService es = Executors.newFixedThreadPool(50);
        //闭锁
        CountDownLatch cdl = new CountDownLatch(5000);
        for (int i = 0;i < 5000; i++){
            es.execute(()->{
                //此处使用了乐观锁 CAS 硬件层面保证的原子性，cas失败会重试
                test.i.incrementAndGet();
                cdl.countDown();
            });
        }
        es.shutdown();
        try {
            //等待5000个任务执行完成后，打印出执行结果
            cdl.await();
            System.out.println("执行完成后，i="+test.i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
