package com.koko.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);

		new Thread(new Task(semaphore)).start();
		new Thread(new Task(semaphore)).start();
		new Thread(new Task(semaphore)).start();
		new Thread(new Task(semaphore)).start();
	}
}

class Task implements Runnable {

	Semaphore semaphore;

	public Task(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " acquired");

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println(Thread.currentThread().getName() + " released");
		}
	}
}
