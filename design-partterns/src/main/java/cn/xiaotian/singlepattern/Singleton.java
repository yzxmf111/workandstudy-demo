package cn.xiaotian.singlepattern;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-01 14:20
 */
public class Singleton {

    /* 饿汉式 -- 线程安全
    private static  Singleton SINGLETON = new Singleton();

     private Singleton(){}

     public static Singleton get() {
         return SINGLETON;
     }
 */

    //懒汉式--线程不安全：适合于
    private static Singleton SINGLETON;

    private Singleton() {
    }

    public static Singleton get() {
        if (SINGLETON == null) {
            SINGLETON = new Singleton();
        }
        return SINGLETON;
    }

}
