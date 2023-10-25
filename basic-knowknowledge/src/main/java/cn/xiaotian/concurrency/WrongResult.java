package cn.xiaotian.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/16 15:48
 **/
public class WrongResult {

	volatile static AtomicInteger i = new AtomicInteger();

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 10000; j++) {
					i.getAndAdd(1);
				}
			}
		};

		Thread thread1 = new Thread(r);
		thread1.start();
		Thread thread2 = new Thread(r);
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(i);

	}

}
