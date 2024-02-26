package cn.xiaotian.concurrency.multi_thread;




import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author yifan.tian
 * @Description 线程池核心参数配置，可动态调整, 此处配置中心是apollo，也可使用其他的配置中心
 * @Date 2024/1/31 11:14
 **/
@Slf4j
@Component
public class ActivitySplitDynamicThreadPoolConfig {

	private static final String NAME_SPACE = "application";

	@Value("${activity.split.core.thread.size:10}")
	private int activitySplitCoreThreadSize;
	@Value("${activity.split.max.thread.size:20}")
	private int activitySplitMaxThreadSize;
	@Value("${activity.split.worker.queue.size:100}")
	private int activitySplitWorkerQueueSize;

	private static final long DEFAULT_KEEP_ALIVE_TIME = 60L;

	private volatile ThreadPoolExecutor activitySplitExecutor;

	public ActivitySplitDynamicThreadPoolConfig() {
		Config config = ConfigService.getConfig(NAME_SPACE);
		listen(config);
	}

	@PostConstruct
	public void init() {
		if (activitySplitExecutor == null) {
			synchronized (ActivitySplitDynamicThreadPoolConfig.class) {
				if (activitySplitExecutor == null) {
					//可以自定义阻塞队列实现，以便实现动态更改队列功能
					BlockingQueue<Runnable> workerQueue = new LinkedBlockingQueue<Runnable>(
							activitySplitWorkerQueueSize);
					activitySplitExecutor = new ThreadPoolExecutor(activitySplitCoreThreadSize, activitySplitMaxThreadSize,
							DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS, workerQueue,
							new CustomPrefixThreadFactory("activitySplit"), new CustomRejectedPolicy());
				}
			}
		}
	}

	public ThreadPoolExecutor getExecutor() {
		return activitySplitExecutor;
	}

	private void listen(Config config) {
		config.addChangeListener(new ConfigChangeListener() {
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				log.info("命名空间发生变化={}", changeEvent.getNamespace());
				for (String key : changeEvent.changedKeys()) {
					ConfigChange change = changeEvent.getChange(key);
					String newValue = change.getNewValue();
					refreshThreadPool(key, newValue);
					log.info("发生变化key={},oldValue={},newValue={},changeType={}",
							change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
				}
			}

		});
	}

	private void refreshThreadPool(String key, String newValue) {
		if (activitySplitExecutor == null) {
			return;
		}
		if (ThreadPoolKeyEnum.ACTIVITY_SPLIT_CORE_THREAD_SIZE.getKey().equals(key)) {
			activitySplitExecutor.setCorePoolSize(Integer.parseInt(newValue));
			log.info("修改核心线程数key={},value={}", key, newValue);
		}
		if (ThreadPoolKeyEnum.ACTIVITY_SPLIT_MAX_THREAD_SIZE.getKey().equals(key)) {
			activitySplitExecutor.setMaximumPoolSize(Integer.parseInt(newValue));
			log.info("修改最大线程数key={},value={}", key, newValue);
		}
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
			log.info("executorService reject execute: {}", r.getClass().getName());
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