package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilterAnElement {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		pickName(friends, "N");
		pickName(friends, "Z");
	}

	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();

		System.out.println(
				String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
	}

	public static void pickName2(final List<String> names, final String startingLetter) {
		String foundName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		System.out.print(String.format("A name starting with %s: ", startingLetter));
		if (foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}
}
