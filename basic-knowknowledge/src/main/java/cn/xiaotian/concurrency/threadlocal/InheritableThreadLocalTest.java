package cn.xiaotian.concurrency.threadlocal;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/19 10:15
 **/
public class InheritableThreadLocalTest {

	public static void main(String[] args) {
		final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
		// 主线程
		threadLocal.set("不擅技术");
		//子线程
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("鄙人三某 ，" + threadLocal.get());
			}
		};
		t.start();
	}
}
