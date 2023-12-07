package cn.xiaotian.concurrency;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/11/28 15:38
 **/


public class RateLimiterDemo {
	public static void main(String[] args) {
//		testNoRateLimiter();
		testWithRateLimiter();
	}

	public static void testNoRateLimiter() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			System.out.println("call execute.." + i);

		}
		Long end = System.currentTimeMillis();

		System.out.println(end - start + "ms");

	}

	public static void testWithRateLimiter() {
		// 创建一个每分钟允许发送30条消息的RateLimiter
		Long start = System.currentTimeMillis();
		RateLimiter rateLimiter = RateLimiter.create(0.5);

		// 模拟发送微信消息
		for (int i = 1; i <= 100; i++) {
			// 尝试获取令牌，如果没有可用的令牌，则阻塞等待
			rateLimiter.acquire();

			// 发送微信消息的逻辑
			sendWeChatMessage(i);
		}
		Long end = System.currentTimeMillis();

		System.out.println(end - start + "ms");


	}

	private static void sendWeChatMessage(int i) {
		System.out.println("我正在发送第" + i+"条消息");
	}

}