package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;

public class ReducingACollection {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		System.out.println(
				"Total number of characters in all names: " + friends.stream().mapToInt(name -> name.length()).sum());
	}
}
