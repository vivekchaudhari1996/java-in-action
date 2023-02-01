package com.koko.java8.inaction.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformElements {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		final List<String> uppercaseNames = new ArrayList<String>();
		// 1.
		for (String name : friends) {
			uppercaseNames.add(name.toUpperCase());
		}
		System.out.println(uppercaseNames + "\n");
		uppercaseNames.clear();

		// 2.
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
		System.out.println(uppercaseNames + "\n");
		uppercaseNames.clear();

		/**
		 * 3. Stream’s map() method can map or transform a sequence of input to
		 * sequence of output. map() method applies the given lambda expression or block
		 * of code, within the parenthesis, on each element in the Stream. the map()
		 * method collects the result of running the lambda expression and returns the
		 * result collection.
		 */
		friends.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));
		System.out.println();

		/**
		 * 4. Stream's map() method will ensure that the same number of elements exists
		 * in the input and the output sequence. However, element types in the input
		 * don’t have to match the element types in the output collection
		 */
		friends.stream().map(name -> name.length()).forEach(count -> System.out.print(count + " "));

		// 5. Using Method References
		friends.stream().map(String::toUpperCase).forEach(name -> System.out.println(name));
	}
}
