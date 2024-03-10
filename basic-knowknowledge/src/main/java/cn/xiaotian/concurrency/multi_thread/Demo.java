package cn.xiaotian.concurrency.multi_thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-22 15:29
 */
public class Demo {

    private static final Map<Integer, Integer> cache = new HashMap<>();
    private static final Map<String, Integer> cache2 = new Hashtable<>();

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            AsyncUtil.execute(new Runnable(){
//               @Override
//               public void run() {
//                   cache.put(new Random().nextInt(10000), new Random().nextInt(10000));
//                   System.out.println(cache);
//               }
//           });
//        }
//        AsyncUtil.shutdown();
        Thread a = new Thread(
                () -> {
                    System.out.println(Thread.class + "");
                }
        );
        a.wait();
        a.start();

    }
}
