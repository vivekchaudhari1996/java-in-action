package com.koko.concurrency.lock;

public class Resource {

	public void doSomething() {
		System.out.println("Resource.doSomething()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doLogging() {
		System.out.println("Resource.doLogging()");
	}
}
