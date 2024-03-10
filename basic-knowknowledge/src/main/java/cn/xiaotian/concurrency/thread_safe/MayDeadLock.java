package cn.xiaotian.concurrency.thread_safe;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author yifan.tian
 * @Description 【死锁：死锁是指两个线程之间相互等待对方资源，但同时又互不相让，都想自己先执行】
 * @Date 2023/12/13 11:00
 **/
public class MayDeadLock {

	public static void main(String[] args) {
		MayDeadLock mayDeadLock = new MayDeadLock();
		new Thread(
				() -> {
					try {
						mayDeadLock.threadOne();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		).start();

		new Thread(
				() -> {
					try {
						mayDeadLock.threadTwo();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		).start();
	}

	final Object one = new Object();
	final Object two = new Object();

	public void threadOne () throws InterruptedException {
		synchronized (one) {
//			one.wait(1000);
			Thread.sleep(1000);
			synchronized (two) {
				System.out.println("thread one 获取到了两把锁");
				two.notify();
			}
		}
	}
	public void threadTwo () throws InterruptedException {
		synchronized (two) {
//			two.wait(1000);
			Thread.sleep(1000);
			synchronized (one) {
				System.out.println("thread two 获取到了两把锁");
				one.notify();
			}
		}
	}

}
