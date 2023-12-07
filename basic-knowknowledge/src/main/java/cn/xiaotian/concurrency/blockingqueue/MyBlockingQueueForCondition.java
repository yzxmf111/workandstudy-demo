package cn.xiaotian.concurrency.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/12/7 16:58
 **/
public class MyBlockingQueueForCondition {
	private Queue queue;

	private int max = 16;

	private ReentrantLock lock = new ReentrantLock();

	private Condition notEmpty = lock.newCondition();

	private Condition notFull = lock.newCondition();

	public MyBlockingQueueForCondition(int size) {

		this.max = size;

		queue = new LinkedList();

	}

	public void put(Object o) throws InterruptedException {

		lock.lock();

		try {

			while (queue.size() == max) {

				notFull.await();

			}

			queue.add(o);

			notEmpty.signalAll();

		} finally {

			lock.unlock();

		}

	}

	public Object take() throws InterruptedException {

		lock.lock();

		try {

			while (queue.size() == 0) {

				notEmpty.await();

			}

			Object item = queue.remove();

			notFull.signalAll();

			return item;

		} finally {

			lock.unlock();

		}

	}
}
