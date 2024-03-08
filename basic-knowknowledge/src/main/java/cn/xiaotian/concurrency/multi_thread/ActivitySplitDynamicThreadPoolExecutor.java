//package cn.xiaotian.concurrency.multi_thread;
//
//import javax.annotation.Resource;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
///**
// * @Author yifan.tian
// * @Description
// * @Date 2024/1/31 11:19
// **/
//public class ActivitySplitDynamicThreadPoolExecutor {
//
//	@Resource
//	private ActivitySplitDynamicThreadPoolConfig activitySplitDynamicThreadPoolConfig;
//
//	public void execute(Runnable command) {
//		activitySplitDynamicThreadPoolConfig.getExecutor().execute(command);
//	}
//
//	public <T> Future<T> submit(Callable<T> task) {
//		return activitySplitDynamicThreadPoolConfig.getExecutor().submit(task);
//	}
//}
