package cn.xiaotian.multi_thread;

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

//    public static void main(String[] args) {
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
//
//
//    }

    /**
     * 继承Thread类
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is child thread");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("end");
    }
}
