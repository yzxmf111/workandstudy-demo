package cn.xiaotian.concurrency.multi_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-28 10:56
 */
public class CASDemo {


    //private int i=0;
    //public synchronized int add(){
    //    return i++;
    //}

    private AtomicInteger i = new AtomicInteger(0);
    public int add(){
        return i.addAndGet(1);
        //new AtomicStampedReference().compareAndSet(1,2);
    }
}
