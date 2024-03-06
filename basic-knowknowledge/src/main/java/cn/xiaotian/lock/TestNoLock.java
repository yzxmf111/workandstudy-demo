package cn.xiaotian.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaotian
 * @description 测试无锁场景出现的问题
 * @date 2023-05-24 16:34
 */
public class TestNoLock {

    public static void main(String[] args){
        //多线程访问共享资源会产生问题，cabinet即共享资源
        Cabinet cabinet = new Cabinet();
        ExecutorService es = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++){
            final int  storeNumber = i;
            es.execute(()->{
                User user = new User(cabinet,storeNumber);
                synchronized (cabinet){
                    user.useCabinet();
                    if (storeNumber != cabinet.getStoreNumber()) {
                        System.out.println("我是用户"+storeNumber+",我存储的数字是："+cabinet.getStoreNumber());
                    }
                }
            });
        }
        es.shutdown();
    }
}
