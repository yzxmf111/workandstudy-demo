package cn.xiaotian.concurrency.multi_thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaotian
 * @description ：线程池
 * @date 2023-02-22 15:27
 */

///**
// * 线程池.
// */
public class AsyncUtil {

    private final static Logger logger          = LoggerFactory.getLogger(AsyncUtil.class);

    private static final int                corePoolSize    = Runtime.getRuntime().availableProcessors() * 5;                        // 通常20

    private static final int                maxPoolSize     = corePoolSize * 20;                                                     // 400

    private static final int                maxQueueSize    = maxPoolSize * 20;                                                      // 8000

    private static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(maxQueueSize),
            new CustomPrefixThreadFactory("AsyncUtil"),
            new CustomRejectedPolicy());

    public static void execute(Runnable command) {
        logger.debug("execute command :{}", System.currentTimeMillis());
        executorService.execute(command);
    }

    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        logger.debug("invokeAll command:{} ,count:{}", System.currentTimeMillis(), tasks.size());
        try {
            return executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Future<T> submit(Callable<T> task) {
        logger.debug("submit command :{}", System.currentTimeMillis());
        return executorService.submit(task);
    }

    /**
     * 提交带名字的task，方便记录
     *
     * @param task     任务
     * @param taskName 任务名称
     * @param <T>      泛型
     * @return 执行future
     */
    public static <T> Future<T> submit(Callable<T> task, String taskName) {
        logger.debug("submit command :{}, task name: {}.", System.currentTimeMillis(), taskName);
        return executorService.submit(task);
    }

    public static void shutdown() {
        try {
            executorService.shutdown();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static boolean isBusy() {
        return executorService.getActiveCount() > executorService.getCorePoolSize();
    }

    public static void printPoolParas() {
        logger.info("ActiveCount: {}, TaskCount: {}, CorePoolSize: {}, PoolSize: {}, Queue.size: {}",
                executorService.getActiveCount(), executorService.getTaskCount(), executorService.getCorePoolSize(),
                executorService.getPoolSize(), executorService.getQueue().size());
    }

    private static class CustomPrefixThreadFactory implements java.util.concurrent.ThreadFactory {

        private static final AtomicInteger poolNumber   = new AtomicInteger(1);
        private final ThreadGroup          group;
        private final AtomicInteger        threadNumber = new AtomicInteger(1);
        private final String               namePrefix;

        public CustomPrefixThreadFactory(String customPrefix){
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = (null == customPrefix ? "" : customPrefix) + "-pool-" + poolNumber.getAndIncrement()
                    + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    private static class CustomRejectedPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            logger.info("executorService reject execute: {}", r.getClass().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // do nothing
            }
            if (!executor.isShutdown()) {
                executor.execute(r);
            }
        }
    }
}
