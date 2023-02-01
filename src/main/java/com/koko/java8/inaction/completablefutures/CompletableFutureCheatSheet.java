package com.koko.java8.inaction.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
 *
 * public static CompletableFuture<Void> runAsync(Runnable runnable)
 *
 * public static <U> CompletableFuture<U> completedFuture(U value)
 *
 * public T join()
 *
 * public T getNow(T valueIfAbsent)
 *
 * public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
 *
 * public CompletableFuture<Void> thenAccept(Consumer<? super T> action)
 *
 * public CompletableFuture<Void> thenRun(Runnable action)
 * 
 * </pre>
 */
public class CompletableFutureCheatSheet {

	private static int compute(int data) {
		sleep(2);
		return data;
	}

	public static void main(String[] args) {
		// supplyAsync
		// thenAccept - is executed with this stage's result as the argument to the
		// supplied action (like forEach of stream)
		CompletableFuture.supplyAsync(() -> "Hello World").thenAccept(data -> System.out.println(data));

		// runAsync
		CompletableFuture.runAsync(() -> System.out.println("Running using runnable"));

		// completedFuture
		CompletableFuture.completedFuture(42).thenAccept(data -> System.out.println(data));

		// join
		// Returns the result value when complete, or throws an (unchecked) exception if
		// completed exceptionally.
		String result = CompletableFuture.supplyAsync(() -> "Hello World").join();
		System.out.println("Result using join :" + result);

		// getNow - Returns the result value if completed, else returns the given
		// valueIfAbsent.
		// thenApply/thenApplyAsync -> to transform the result like map of stream
		int output = CompletableFuture.supplyAsync(() -> compute(2)).thenApply(data -> data + 1).getNow(4);
		System.out.println("Result using getNow :" + output);

		// thenRun - executes the given action
		CompletableFuture.supplyAsync(() -> "Hello World").thenAccept(data -> System.out.println(data))
				.thenRun(() -> System.out.println("Done !!!"));
	}

	private static void sleep(int timeout) {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
