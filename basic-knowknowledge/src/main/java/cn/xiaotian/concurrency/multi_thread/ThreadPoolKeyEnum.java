package cn.xiaotian.concurrency.multi_thread;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/1/31 11:19
 **/
public enum ThreadPoolKeyEnum {
	/** 线程池核心参数*/
	ACTIVITY_SPLIT_CORE_THREAD_SIZE("activity.split.core.thread.size", "活动拆分核心线程数"),

	ACTIVITY_SPLIT_MAX_THREAD_SIZE("activity.split.max.thread.size", "活动拆分最大线程数"),

	ACTIVITY_SPLIT_WORKER_QUEUE_SIZE("activity.split.worker.queue.size", "活动拆分队列最大缓存任务数")

			;

	private String key;
	private String desc;

	ThreadPoolKeyEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}
}
