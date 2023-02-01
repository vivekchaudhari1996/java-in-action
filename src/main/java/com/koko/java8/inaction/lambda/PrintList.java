package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class PrintList {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		System.out.println(String.join(", ", friends));

		System.out.println(friends.stream().map(String::toUpperCase).collect(joining(", ")));

	}
}
