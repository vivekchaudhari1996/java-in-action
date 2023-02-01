package com.koko.java8.inaction.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterElements {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		List<String> startsWithN = new ArrayList<String>();

		// 1.
		for (String name : friends) {
			if (name.startsWith("N")) {
				startsWithN.add(name);
			}
		}
		System.out.println(String.format("Found %d names", startsWithN.size()));
		startsWithN.clear();

		/**
		 * 2. filter() method expects a lambda expression that returns a boolean result.
		 * If the lambda expression returns a true, the element in context while
		 * executing that lambda expression is added to a result collection; it's
		 * skipped otherwise.
		 */
		startsWithN = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());
		System.out.println(String.format("Found %d names", startsWithN.size()));
	}
}
