package com.koko.concurrency.future;

import java.util.concurrent.*;

public class FutureExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();

		SumTask sumTask = new SumTask(20);
		Future<Integer> future = service.submit(sumTask);
		Integer result = 0;
		try {
			result = future.get(3, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}

class SumTask implements Callable<Integer> {
	private int num;

	public SumTask(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		for (int i = 1; i <= num; i++) {
			result += i;
			Thread.sleep(100);
		}
		return result;
	}
}
