package com.koko.java8.inaction.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		sumUsingReduce(numbers);
		minMaxUsingReduce(numbers);

		reduceUsingParallelStream(numbers);
	}

	private static void reduceUsingParallelStream(List<Integer> numbers) {
		int sum = numbers.parallelStream().reduce(0, Integer::sum);
		System.out.println("Sum usign parallel stream :" + sum);
	}

	private static void minMaxUsingReduce(List<Integer> numbers) {
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println("Min is :" + min);

		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println("Max is :" + max);
	}

	private static void sumUsingReduce(List<Integer> numbers) {
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum is :" + sum);

		// using method reference
		sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum is :" + sum);
	}
}
