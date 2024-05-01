package cn.xiaotian.concurrency.thread.methods;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/17 17:27
 **/
public class ProducerConsumerExample {
	private static final int CAPACITY = 5;
	private volatile static List<Integer> buffer = new ArrayList<>();

	public static void main(String[] args) {
		Thread producerThread = new Thread(new Producer());
		Thread consumerThread = new Thread(new Consumer());

		producerThread.start();
		consumerThread.start();
	}

	static class Producer implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (buffer) {
					try {
						// 如果缓冲区满了，则等待
						while (buffer.size() == CAPACITY) {
							System.out.println("Buffer is full. Producer is waiting...");
							buffer.wait();
						}
						// 生产一个物品并添加到缓冲区
						int item = (int) (Math.random() * 100);
						buffer.add(item);
						System.out.println("Produced: " + item);
						// 通知消费者线程可以从缓冲区取出物品了
						buffer.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 睡眠一段时间模拟生产过程
				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (buffer) {
					try {
						// 如果缓冲区为空，则等待
						while (buffer.isEmpty()) {
							System.out.println("Buffer is empty. Consumer is waiting...");
							buffer.wait();
						}
						// 从缓冲区取出一个物品并消费
						int item = buffer.remove(0);
						System.out.println("Consumed: " + item);
						// 通知生产者线程可以往缓冲区添加物品了
						buffer.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 睡眠一段时间模拟消费过程
				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

