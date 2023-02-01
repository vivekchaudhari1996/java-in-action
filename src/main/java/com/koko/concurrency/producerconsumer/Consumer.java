package com.koko.concurrency.producerconsumer;

public class Consumer implements Runnable {
	private MessageQueue queue;

	public Consumer(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			queue.consumeMessage();
		}
	}
}
