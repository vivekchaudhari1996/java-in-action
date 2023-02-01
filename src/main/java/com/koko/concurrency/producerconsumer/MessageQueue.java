package com.koko.concurrency.producerconsumer;

public class MessageQueue {

	StringBuffer myMonitorObject = new StringBuffer();
	volatile boolean jobDone = false;
	String messages = null;

	public void produceMessage(String message) {

		synchronized (myMonitorObject) {
			while (jobDone) {
				try {
					// System.out.println("Message Queue full, waiting for consumer..");
					myMonitorObject.wait();

				} catch (InterruptedException e) {
				}
			}
			messages = message;
			System.out.println("Producer produced- " + messages);
			jobDone = true;
			myMonitorObject.notify();
		}
	}

	public void consumeMessage() {
		synchronized (myMonitorObject) {
			while (!jobDone) {
				try {
					// System.out.println("Message Queue empty, waiting for producer..");
					myMonitorObject.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("Consumer consumed- " + messages);
			jobDone = false;
			myMonitorObject.notify();
		}
	}
}
