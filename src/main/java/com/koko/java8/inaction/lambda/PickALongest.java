package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickALongest {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		/**
		 * reduce() method to compare two elements against each other and pass along the
		 * result for further comparison with the remaining elements in the collection.
		 *
		 * The result of the reduce() method is an Optional because the list on which
		 * reduce() is called may be empty.
		 */
		final Optional<String> aLongName = friends.stream()
				.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);

		aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));

		/**
		 * This version of reduce() does not return an Optional since if the collection
		 * is empty, the default will be returned.
		 */
		final String steveOrLonger = friends.stream().reduce("Steve",
				(name1, name2) -> name1.length() >= name2.length() ? name1 : name2);

		System.out.println(String.format("A longest name: %s", steveOrLonger));

	}
}
