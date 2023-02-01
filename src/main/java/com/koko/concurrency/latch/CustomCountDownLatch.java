package com.koko.concurrency.latch;

/**
 * Custom CoundDownLach implementation
 *
 * @author sandeep
 */
public class CustomCountDownLatch {
	int counter;

	public CustomCountDownLatch(int counter) {
		this.counter = counter;
	}

	public synchronized void await() throws InterruptedException {
		if (counter > 0) {
			wait();
		}
	}

	/**
	 * method will decrement the counter by 1 each time
	 */
	public synchronized void countDown() {
		counter--;
		if (counter == 0) {
			notifyAll();
		}
	}
}
