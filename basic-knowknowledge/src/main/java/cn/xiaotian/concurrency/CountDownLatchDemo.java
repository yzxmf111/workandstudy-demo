package cn.xiaotian.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/10/24 18:48
 **/
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("运动员有5秒的准备时间");

		CountDownLatch countDownLatch = new CountDownLatch(1);

		ExecutorService service = Executors.newFixedThreadPool(50);

		for (int i = 0; i < 50; i++) {

			final int no = i + 1;

			Runnable runnable = new Runnable() {

				@Override

				public void run() {

					System.out.println(no + "号运动员准备完毕，等待裁判员的发令枪");

					try {

						countDownLatch.await();

						System.out.println(no + "号运动员开始跑步了");

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

				}

			};

			service.submit(runnable);

		}

		Thread.sleep(5000);

		System.out.println("5秒准备时间已过，发令枪响，比赛开始！");

		countDownLatch.countDown();

	}
}
