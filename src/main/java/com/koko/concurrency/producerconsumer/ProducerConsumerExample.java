package com.koko.concurrency.producerconsumer;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue();
		(new Thread(new Producer(messageQueue))).start();
		(new Thread(new Consumer(messageQueue))).start();
	}
}
