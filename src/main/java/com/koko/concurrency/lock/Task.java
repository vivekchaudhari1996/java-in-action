package com.koko.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

	private Resource resource;
	private Lock lock;

	public Task(Resource r) {
		this.resource = r;
		this.lock = new ReentrantLock();
	}

	public void performTask() {
		try {
			boolean flag = lock.tryLock(3, TimeUnit.SECONDS);
			if (flag) {
				try {
					resource.doSomething();
				} finally {
					lock.unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resource.doLogging();
	}
}
