package cn.xiaotian.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaotian
 * @description
 * @date 2023-05-24 17:40
 */
public class Cas {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        i.compareAndSet(0, 2);
        System.out.println(i);
        i.getAndIncrement();
        System.out.println(i);
        i.incrementAndGet();
        System.out.println(i);
        if (i.compareAndSet(0, 4)) {
            System.out.println(i);
        } else {
            System.out.println(i + "2");
        }
    }
}
