package com.koko.concurrency.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Party implements Runnable {
	CyclicBarrier barrier;

	public Party(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " waiting at barrier.");
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
