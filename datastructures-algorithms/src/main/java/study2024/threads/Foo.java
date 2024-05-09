package study2024.threads;

import java.util.concurrent.Semaphore;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/9 14:44
 **/
public class Foo {
	// private volatile boolean oneDown;
	// private volatile boolean twoDown;

	private Semaphore s2 = new Semaphore(0);
	private Semaphore s3 = new Semaphore(0);

	public Foo() {

	}

	// public synchronized void first(Runnable printFirst) throws InterruptedException {
	// 	printFirst.run();
	// 	oneDown = true;
	// 	notifyAll();
	// }
	//
	// public synchronized void second(Runnable printSecond) throws InterruptedException {
	// 	if (!oneDown) {
	// 		wait();
	// 	}
	// 	printSecond.run();
	// 	twoDown = true;
	// 	notifyAll();
	// }
	//
	// public synchronized void third(Runnable printThird) throws InterruptedException {
	// 	if (!twoDown) {
	// 		wait();
	// 	}
	// 	printThird.run();
	// }


	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		s2.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		s2.acquire();
		printSecond.run();
		s3.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		s3.acquire();
		printThird.run();
	}

	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread one = new Thread(
				() -> {
					try {
						foo.first(() -> System.out.print("first"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		);
		Thread two = new Thread(
				() -> {
					try {
						foo.first(() -> System.out.print("second"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		);
		Thread three = new Thread(
				() -> {
					try {
						foo.first(() -> System.out.print("third"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		);
		three.start();
		one.start();
		two.start();
	}

}