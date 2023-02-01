package com.koko.concurrency.lock;

public class TryLockExample {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Task task = new Task(resource);

		new Thread(new Worker(task)).start();
		new Thread(new Worker(task)).start();
	}
}
