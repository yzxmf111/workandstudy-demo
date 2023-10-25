package cn.xiaotian.concurrency;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/10/25 13:33
 **/
public class SemaphoreDemo {
	public static void main(String[] args) {
		// 创建一个Semaphore，限制并发数为2
		Semaphore semaphore = new Semaphore(2);

		// 模拟多个线程尝试访问临界资源
		for (int i = 1; i <= 5; i++) {
			Thread thread = new Thread(new Worker(semaphore, i));
			thread.start();
		}
	}

	static class Worker implements Runnable {
		private final Semaphore semaphore;
		private final int id;

		public Worker(Semaphore semaphore, int id) {
			this.semaphore = semaphore;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				// 尝试获取Semaphore许可证，如果没有可用的许可证则等待
				semaphore.acquire();
				System.out.println("Worker " + id + " is working...");
				Thread.sleep(2000); // 模拟工作
				System.out.println("Worker " + id + " has finished working.");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				// 任务完成后释放Semaphore许可证
				semaphore.release();
			}
		}
	}


}
