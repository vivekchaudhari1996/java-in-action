package com.koko.java8.inaction.lambda;

import com.koko.java8.inaction.lambda.model.Apple;
import com.koko.java8.inaction.lambda.model.Apple.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple(100, Color.RED), new Apple(200, Color.GREEN));

		// filter all red apples
		List<Apple> results = filter(apples, (Apple a) -> Color.RED.equals(a.getColor()));
		results.forEach(System.out::println);
	}

	private static <E> List<E> filter(List<E> elements, Predicate<E> predicate) {
		List<E> results = new ArrayList<E>();

		for (E e : elements) {
			if (predicate.test(e)) {
				results.add(e);
			}
		}
		return results;
	}
}
