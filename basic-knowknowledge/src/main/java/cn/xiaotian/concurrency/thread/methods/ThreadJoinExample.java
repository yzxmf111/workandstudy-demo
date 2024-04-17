package cn.xiaotian.concurrency.thread.methods;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/17 16:51
 **/
public class ThreadJoinExample {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1 is running.");
			try {
				Thread.sleep(2000); // 模拟工作，持续2秒
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread 1 was interrupted.");
			}
			System.out.println("Thread 1 completed.");
		});

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2 is running.");
			try {
				Thread.sleep(1000); // 模拟工作，持续1秒
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread 2 was interrupted.");
			}
			System.out.println("Thread 2 completed.");
		});

		thread1.start();
		thread2.start();

		try {
			System.out.println("Waiting for Thread 1 to finish.");
			thread1.join();  // 等待线程1完成
			System.out.println("Thread 1 has finished.");
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted while waiting for thread1.");
		}

		try {
			System.out.println("Waiting for Thread 2 to finish.");
			thread2.join();  // 等待线程2完成
			System.out.println("Thread 2 has finished.");
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted while waiting for thread2.");
		}

		System.out.println("Both threads have finished. Exiting program.");
	}
}
