package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		forEach(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (Integer i) -> System.out.println(i));
	}

	private static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}
}
