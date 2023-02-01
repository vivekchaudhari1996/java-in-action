package com.koko.concurrency.producerconsumer;

import java.util.Random;

public class Producer implements Runnable {
	private MessageQueue queue;

	public Producer(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			queue.produceMessage("Message " + i);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}
