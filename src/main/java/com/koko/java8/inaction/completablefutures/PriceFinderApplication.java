package com.koko.java8.inaction.completablefutures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.stream.Collectors.toList;

public class PriceFinderApplication {

	public static void main(String arg[]) {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"), new Shop("Alibaba"));

		// using stream it will take time more than 4+ sec
		long start = System.nanoTime();
		System.out.println(findPrices(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");

		// using parallel stream it will take time more than 1+ sec
		start = System.nanoTime();
		System.out.println(findPricesUsingParallelStream(shops, "myPhone27S"));
		System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs");

		// Making asynchronous requests with CompletableFutures
		start = System.nanoTime();
		System.out.println(findPricesAsynchronously(shops, "myPhone27S"));
		System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs");
	}

	public static List<String> findPrices(List<Shop> shops, String product) {
		return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(toList());
	}

	public static List<String> findPricesUsingParallelStream(List<Shop> shops, String product) {
		return shops.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(toList());
	}

	public static List<String> findPricesAsynchronously(List<Shop> shops, String product) {

		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});

		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(
						() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor))
				.collect(toList());

		return priceFutures.stream().map(CompletableFuture::join).collect(toList());
	}
}
