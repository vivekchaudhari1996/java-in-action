package com.koko.concurrency.barrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new BarrierAction());

		new Thread(new Party(barrier)).start();
		new Thread(new Party(barrier)).start();
		new Thread(new Party(barrier)).start();

		try {
			// sleep to avoid BrokenBarrierException
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nReset the barrier....\n");
		// reset the barrier
		barrier.reset();

		new Thread(new Party(barrier)).start();
		new Thread(new Party(barrier)).start();
		new Thread(new Party(barrier)).start();
	}
}
