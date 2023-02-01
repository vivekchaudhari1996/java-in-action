package com.koko.concurrency;

public class HelloThread {

	public static void main(String args[]) {

		new Thread(() -> {
			System.out.println("Hello from a thread");
		}).start();
	}
}
