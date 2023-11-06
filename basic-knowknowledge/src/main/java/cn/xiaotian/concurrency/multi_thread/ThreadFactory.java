package cn.xiaotian.concurrency.multi_thread;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-22 14:13
 */
public class ThreadFactory {

    public static void main(String[] args) {
        //https://developer.aliyun.com/article/1048734
      //public ThreadPoolExecutor(int coreSize,int maxSize,long KeepAliveTime,TimeUnit unit,BlockingQueue queue,ThreadFactory factory,RejectedExectionHandler handler)
        //corePoolSize： 核心线程数，也是线程池中常驻的线程数，线程池初始化时默认是没有线程的，当任务来临时才开始创建线程去执行任务
        //maximumPoolSize： 最大线程数，在核心线程数的基础上可能会额外增加一些非核心线程，需要注意的是只有当workQueue队列填满时才会创建多于corePoolSize的线程(线程池总线程数不超过maxPoolSize)
        //keepAliveTime： 非核心线程的空闲时间超过keepAliveTime就会被自动终止回收掉，注意当corePoolSize=maxPoolSize时，keepAliveTime参数也就不起作用了(因为不存在非核心线程)；
        //unit： keepAliveTime的时间单位
        //workQueue： 用于保存任务的队列，可以为无界、有界、同步移交三种队列类型之一，当池子里的工作线程数大于corePoolSize时，这时新进来的任务会被放到队列中
        //threadFactory： 创建线程的工厂类，默认使用Executors.defaultThreadFactory()，也可以使用guava库的ThreadFactoryBuilder来创建
        //handler： 线程池无法继续接收任务(队列已满且线程数达到maximunPoolSize)时的饱和拒绝策略，取值有AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy
        // 3.1 线程池大小的设置
        //3.2 参数配置
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager!= null ? securityManager.getThreadGroup(): Thread.currentThread().getThreadGroup());
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

    }
//
}
//
//
//
//
//
///**
// * 线程池.
// */
//public class AsyncUtil {
//
//    private final static Logger logger          = LoggerFactory.getLogger(AsyncUtil.class);
//
//    private static final int                corePoolSize    = Runtime.getRuntime().availableProcessors() * 5;                        // 通常20
//
//    private static final int                maxPoolSize     = corePoolSize * 20;                                                     // 400
//
//    private static final int                maxQueueSize    = maxPoolSize * 20;                                                      // 8000
//
//    private static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 60L,
//            TimeUnit.SECONDS,
//            new LinkedBlockingQueue<Runnable>(maxQueueSize),
//            new CustomPrefixThreadFactory("AsyncUtil"),
//            new CustomRejectedPolicy());
//
//    public static void execute(Runnable command) {
//        logger.debug("execute command :{}", System.currentTimeMillis());
//        executorService.execute(command);
//    }
//
//    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
//        logger.debug("invokeAll command:{} ,count:{}", System.currentTimeMillis(), tasks.size());
//        try {
//            return executorService.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static <T> Future<T> submit(Callable<T> task) {
//        logger.debug("submit command :{}", System.currentTimeMillis());
//        return executorService.submit(task);
//    }
//
//    /**
//     * 提交带名字的task，方便记录
//     *
//     * @param task     任务
//     * @param taskName 任务名称
//     * @param <T>      泛型
//     * @return 执行future
//     */
//    public static <T> Future<T> submit(Callable<T> task, String taskName) {
//        logger.debug("submit command :{}, task name: {}.", System.currentTimeMillis(), taskName);
//        return executorService.submit(task);
//    }
//
//    public static void shutdown() {
//        try {
//            executorService.shutdown();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
//
//    public static boolean isBusy() {
//        return executorService.getActiveCount() > executorService.getCorePoolSize();
//    }
//
//    public static void printPoolParas() {
//        logger.info("ActiveCount: {}, TaskCount: {}, CorePoolSize: {}, PoolSize: {}, Queue.size: {}",
//                executorService.getActiveCount(), executorService.getTaskCount(), executorService.getCorePoolSize(),
//                executorService.getPoolSize(), executorService.getQueue().size());
//    }
//
//    private static class CustomPrefixThreadFactory implements java.util.concurrent.ThreadFactory {
//
//        private static final AtomicInteger poolNumber   = new AtomicInteger(1);
//        private final ThreadGroup          group;
//        private final AtomicInteger        threadNumber = new AtomicInteger(1);
//        private final String               namePrefix;
//
//        public CustomPrefixThreadFactory(String customPrefix){
//            SecurityManager s = System.getSecurityManager();
//            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
//            namePrefix = (null == customPrefix ? "" : customPrefix) + "-pool-" + poolNumber.getAndIncrement()
//                    + "-thread-";
//        }
//
//        @Override
//        public Thread newThread(Runnable r) {
//            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
//            if (t.isDaemon()) {
//                t.setDaemon(false);
//            }
//            if (t.getPriority() != Thread.NORM_PRIORITY) {
//                t.setPriority(Thread.NORM_PRIORITY);
//            }
//            return t;
//        }
//    }
//
//    private static class CustomRejectedPolicy implements RejectedExecutionHandler {
//
//        @Override
//        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            logger.info("executorService reject execute: {}", r.getClass().getName());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                // do nothing
//            }
//            if (!executor.isShutdown()) {
//                executor.execute(r);
//            }
//        }
//    }
//}
///**
// * 线程池.
// */
//public class AsyncUtil {
//
//    private final static Logger logger          = LoggerFactory.getLogger(AsyncUtil.class);
//
//    private static final int                corePoolSize    = Runtime.getRuntime().availableProcessors() * 5;                        // 通常20
//
//    private static final int                maxPoolSize     = corePoolSize * 20;                                                     // 400
//
//    private static final int                maxQueueSize    = maxPoolSize * 20;                                                      // 8000
//
//    private static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 60L,
//            TimeUnit.SECONDS,
//            new LinkedBlockingQueue<Runnable>(maxQueueSize),
//            new CustomPrefixThreadFactory("AsyncUtil"),
//            new CustomRejectedPolicy());
//
//    public static void execute(Runnable command) {
//        logger.debug("execute command :{}", System.currentTimeMillis());
//        executorService.execute(command);
//    }
//
//    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
//        logger.debug("invokeAll command:{} ,count:{}", System.currentTimeMillis(), tasks.size());
//        try {
//            return executorService.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static <T> Future<T> submit(Callable<T> task) {
//        logger.debug("submit command :{}", System.currentTimeMillis());
//        return executorService.submit(task);
//    }
//
//    /**
//     * 提交带名字的task，方便记录
//     *
//     * @param task     任务
//     * @param taskName 任务名称
//     * @param <T>      泛型
//     * @return 执行future
//     */
//    public static <T> Future<T> submit(Callable<T> task, String taskName) {
//        logger.debug("submit command :{}, task name: {}.", System.currentTimeMillis(), taskName);
//        return executorService.submit(task);
//    }
//
//    public static void shutdown() {
//        try {
//            executorService.shutdown();
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
//
//    public static boolean isBusy() {
//        return executorService.getActiveCount() > executorService.getCorePoolSize();
//    }
//
//    public static void printPoolParas() {
//        logger.info("ActiveCount: {}, TaskCount: {}, CorePoolSize: {}, PoolSize: {}, Queue.size: {}",
//                executorService.getActiveCount(), executorService.getTaskCount(), executorService.getCorePoolSize(),
//                executorService.getPoolSize(), executorService.getQueue().size());
//    }
//
//    private static class CustomPrefixThreadFactory implements java.util.concurrent.ThreadFactory {
//
//        private static final AtomicInteger poolNumber   = new AtomicInteger(1);
//        private final ThreadGroup          group;
//        private final AtomicInteger        threadNumber = new AtomicInteger(1);
//        private final String               namePrefix;
//
//        public CustomPrefixThreadFactory(String customPrefix){
//            SecurityManager s = System.getSecurityManager();
//            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
//            namePrefix = (null == customPrefix ? "" : customPrefix) + "-pool-" + poolNumber.getAndIncrement()
//                    + "-thread-";
//        }
//
//        @Override
//        public Thread newThread(Runnable r) {
//            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
//            if (t.isDaemon()) {
//                t.setDaemon(false);
//            }
//            if (t.getPriority() != Thread.NORM_PRIORITY) {
//                t.setPriority(Thread.NORM_PRIORITY);
//            }
//            return t;
//        }
//    }
//
//    private static class CustomRejectedPolicy implements RejectedExecutionHandler {
//
//        @Override
//        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            logger.info("executorService reject execute: {}", r.getClass().getName());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                // do nothing
//            }
//            if (!executor.isShutdown()) {
//                executor.execute(r);
//            }
//        }
//    }
//}


