package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReusingLambdaExpressions {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

		/**
		 * assign lambda expressions to variables and reuse them, just like with
		 * objects. filter() method takes a reference to a java.util.function.Predicate
		 * functional interface.
		 */
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final long countFriendsStartN = friends.stream().filter(startsWithN).count();
		final long countEditorsStartN = editors.stream().filter(startsWithN).count();
		final long countComradesStartN = comrades.stream().filter(startsWithN).count();
	}
}
