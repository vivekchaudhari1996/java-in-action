package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TraverseElements {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// 1.
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}

		// 2.
		for (String name : friends) {
			System.out.println(name);
		}

		// 3.
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});

		// 4.
		friends.forEach((final String name) -> System.out.println(name));

		// 5. Java compiler determines the name parameter’s a String type
		friends.forEach((name) -> System.out.println(name));

		// 6.
		friends.forEach(name -> System.out.println(name));

		// 7. method reference
		friends.forEach(System.out::println);
	}
}
