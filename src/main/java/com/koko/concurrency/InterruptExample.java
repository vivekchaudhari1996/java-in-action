package com.koko.concurrency;

public class InterruptExample implements Runnable {
	public static void main(String args[]) {

		Thread t = new Thread(new InterruptExample());
		t.start();
		t.interrupt();
	}

	public void run() {
		for (int i = 0; i < 1000000000; i++) {
			int k = i + 1;
			k = i / k;
			k = k * i;
		}
		System.out.println("Is thread interrupted " + Thread.currentThread().isInterrupted());
		System.out.println("Is thread interrupted " + Thread.currentThread().isInterrupted());
		System.out.println("Is thread interrupted " + Thread.interrupted());
		System.out.println("Is thread interrupted " + Thread.currentThread().isInterrupted());
	}
}
