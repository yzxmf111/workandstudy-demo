package cn.xiaotian.concurrency.blockingqueue;

import java.util.LinkedList;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/12/7 17:23
 **/
public class MyBlockingQueue {
	private int maxSize;

	private LinkedList<Object> storage;

	public MyBlockingQueue(int size) {

		this.maxSize = size;

		storage = new LinkedList<>();

	}

	public synchronized void put() throws InterruptedException {

		while (storage.size() == maxSize) {

			wait();

		}

		storage.add(new Object());

		notifyAll();

	}

	public synchronized void take() throws InterruptedException {

		while (storage.size() == 0) {

			wait();

		}

		System.out.println(storage.remove());

		notifyAll();

	}



}
