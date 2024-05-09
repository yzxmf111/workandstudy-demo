package study2024.threads;

import java.util.concurrent.Semaphore;

/**
 * @Author yifan.tian
 * @Description 交替打印
 * @Date 2024/5/9 15:34
 **/
public class FooBar {
	private int n;

	Semaphore fooS = new Semaphore(1);
	Semaphore fooB = new Semaphore(0);


	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			fooS.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			fooS.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			fooB.acquire();
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			fooS.release(1);
		}
	}
}
