package com.koko.java8.inaction.completablefutures;

import java.util.concurrent.*;

/**
 * <pre>
 *
 * public <U> CompletableFuture<U> thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn)
 * </pre>
 */
public class CompletableFutureThenCompose {

	private static void sleep(int timeout) {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    private static int compute(int data) {
        System.out.println(Thread.currentThread());
        sleep(2);
        return data;
    }

    private static CompletableFuture<Integer> create(int data, Executor executor) {
        return CompletableFuture.supplyAsync(() -> compute(data), executor);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Executor executor = Executors.newFixedThreadPool(Math.min(10, 100), new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        // thenCombine - is executed with the two results as arguments to the supplied
        // function
        CompletableFuture<Integer> future = create(2, executor)
                .thenCombineAsync(create(3, executor), (result1, result2) -> result1 + result2)
                .thenCombineAsync(create(5, executor), (result3, result4) -> result3 + result4)
                .thenCombineAsync(create(10, executor), (result3, result4) -> result3 + result4);

        System.out.println("Result :" + future.join());

        long duration = (System.currentTimeMillis() - start) / 1_000;
        System.out.println("Done in " + duration + " secs");
    }


}
