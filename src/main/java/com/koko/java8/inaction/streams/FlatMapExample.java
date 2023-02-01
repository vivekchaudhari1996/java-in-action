package com.koko.java8.inaction.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();

		words.add("Hello");
		words.add("World");

		// the flatMap method lets you replace each value of a stream with another
		// stream and then concatenates all the generated streams into a single stream.
		List<String> uniqueWords = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		uniqueWords.forEach(System.out::println);
	}
}
