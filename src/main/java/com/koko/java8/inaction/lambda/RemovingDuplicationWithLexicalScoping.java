package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class RemovingDuplicationWithLexicalScoping {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// 1. the two predicates are mere duplicates, with only the letter they use
		// being different
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");
		long countFriendsStartN = friends.stream().filter(startsWithN).count();
		long countFriendsStartB = friends.stream().filter(startsWithB).count();

		// 2. Removing Duplication with Lexical Scoping
		countFriendsStartN = friends.stream().filter(checkIfStartsWith("N")).count();
		countFriendsStartB = friends.stream().filter(checkIfStartsWith("B")).count();

		// 3. Refactoring to Narrow the Scope
		Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
			Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
			return checkStarts;
		};

		startsWithLetter = (String letter) -> (String name) -> name.startsWith(letter);

		startsWithLetter = letter -> name -> name.startsWith(letter);

		countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
		countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();
	}

	/**
	 * From within a lambda expression we can only access local variables that are
	 * final or effectively final in the enclosing scope
	 *
	 * @param letter
	 * @return
	 */
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}
}
