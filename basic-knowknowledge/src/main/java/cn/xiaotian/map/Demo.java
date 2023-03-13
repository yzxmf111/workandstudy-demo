package cn.xiaotian.map;

import java.util.concurrent.Executors;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-22 13:56
 */
public class Demo {


    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);
    }
}