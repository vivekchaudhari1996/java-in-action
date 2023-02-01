package com.koko.java8.inaction.completablefutures;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static void main(String arg[]) {
        Shop shop = new Shop("Amazon");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("kitkat");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation return after :" + invocationTime + " msecs");
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {

        }
        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Retrieval return after :" + retrievalTime + " msecs");
    }

    public String getPriceWithDiscount(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }


    /**
     * Simple get price without using future
     *
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * Converting synchronous method to asynchronous
     *
     * @param product
     * @return future
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            } catch (Exception e) {
                future.completeExceptionally(e); // handling exception and return back
            }
        }).start();
        return future;
    }


    /**
     * Creating a CompletableFuture with the supplyAsync factory method
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceUsingSupplyAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
