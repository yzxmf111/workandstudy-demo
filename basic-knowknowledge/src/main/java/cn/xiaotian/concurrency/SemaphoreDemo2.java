package cn.xiaotian.concurrency;

import cn.xiaotian.concurrency.multi_thread.AsyncUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/10/30 10:34
 **/
public class SemaphoreDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// 创建一个Semaphore，限制并发数为2
		Semaphore semaphore = new Semaphore(2);
		List<String> skuResponses = new ArrayList<>();
		long start = System.currentTimeMillis();
		// 模拟多个线程尝试访问临界资源
		List<Future<String>> invokeResult = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			semaphore.acquire();
			int finalI = i;
			invokeResult.add(
					AsyncUtil.submit(
							() -> {
								try {
									System.out.println("第"+ finalI +"个thread is run");
									return mockInvokeInteface();
								} finally {
									semaphore.release();
								}
							}
					)
			);

			invokeResult.forEach(
					res -> {
						try {
							skuResponses.add(res.get());
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}
			);
		}
		long end = System.currentTimeMillis();

		System.out.println(skuResponses);
		System.out.println("总耗时:" +  (end - start)/1000L);
	}

	public static String mockInvokeInteface() throws InterruptedException {
		Random random = new Random();
		Thread.sleep(random.nextInt(1000) + 100);
		return "";
	}
}
