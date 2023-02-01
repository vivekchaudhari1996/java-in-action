package com.koko.concurrency.barrier;

/**
 * BarrierAction run once per barrier point, after the last thread in the party
 * arrives, but before any threads are released
 */
public class BarrierAction implements Runnable {

	@Override
	public void run() {
		System.out.println("Barrier Action Executes !!!");
	}
}
