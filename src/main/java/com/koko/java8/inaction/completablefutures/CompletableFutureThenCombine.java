package com.koko.java8.inaction.completablefutures;

import java.util.concurrent.CompletableFuture;

/**
 * <pre>
 *
 * public <U,V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> other,
 * BiFunction<? super T,? super U,? extends V> fn)
 * </pre>
 */
public class CompletableFutureThenCombine {

    private static CompletableFuture<Integer> create(int data) {
        return CompletableFuture.supplyAsync(() -> data);
    }

    private static CompletableFuture<Integer> increment(int data) {
        return CompletableFuture.supplyAsync(() -> data + 1);
    }

    public static void main(String[] args) {
        // thenCompose is used if you have an asynchronous mapping function (i.e. one
        // that returns a CompletableFuture). It will then return a future with the
        // result directly, rather than a nested future.

        CompletableFuture.supplyAsync(() -> 1).thenCompose(x -> CompletableFuture.supplyAsync(() -> x + 1))
                .thenAccept(data -> System.out.println(data));

        create(2)
                // .thenApply(data -> increment(data))
                .thenCompose(data -> increment(data)).thenAccept(data -> System.out.println(data));
    }
}
