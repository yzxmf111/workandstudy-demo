package cn.xiaotian.concurrency.blockingqueue;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/12/7 17:29
 **/
public class WaitStyle {

	public static void main(String[] args) {

		MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);

		Producer producer = new Producer(myBlockingQueue);

		Consumer consumer = new Consumer(myBlockingQueue);

		new Thread(producer).start();

		new Thread(consumer).start();

	}

}

class Producer implements Runnable {

	private MyBlockingQueue storage;

	public Producer(MyBlockingQueue storage) {

		this.storage = storage;

	}

	@Override

	public void run() {

		for (int i = 0; i < 100; i++) {

			try {

				storage.put();

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

}

class Consumer implements Runnable {

	private MyBlockingQueue storage;

	public Consumer(MyBlockingQueue storage) {

		this.storage = storage;

	}

	@Override

	public void run() {

		for (int i = 0; i < 100; i++) {

			try {

				storage.take();

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

}
