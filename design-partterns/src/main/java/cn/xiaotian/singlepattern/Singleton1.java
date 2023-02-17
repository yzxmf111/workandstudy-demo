package cn.xiaotian.singlepattern;

public class Singleton1 {

//    /**
//     *懒汉模式双重锁校验
//     **/
//    private static volatile Singleton instance = null;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        //先检查实例是否存在，如果不存在才进入下面的同步块
//        if(instance == null){
//            //同步块，线程安全的创建实例
//            synchronized (Singleton.class) {
//                //再次检查实例是否存在，如果不存在才真正的创建实例
//                if(instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /* 私有构造方法，防止被实例化 */
    private Singleton1() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton1 instance = new Singleton1();
    }

    /* 获取实例 */
    public static Singleton1 getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}

