package com.koko.java8.inaction.streams;

import com.koko.java8.inaction.streams.model.Dish;
import com.koko.java8.inaction.streams.util.MenuProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithStreams {
	public static void main(String[] args) {
		List<Dish> menu = MenuProvider.getMenu();

		System.out.println("============Filtering a stream with a predicate============");
		// Filtering a stream with a predicate
		List<String> vegDishes = menu.stream().filter(Dish::isVegetarian).map(Dish::getName)
				.collect(Collectors.toList());
		vegDishes.forEach(System.out::println);

		System.out.println("============Filtering unique elements using distinct============");
		// Filtering unique elements using distinct
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		System.out.println("============Truncating a stream using limit============");
		// Truncating a stream using limit
		List<String> threeHighCaloriesDishes = menu.stream().filter(d -> d.getCalories() > 400).limit(3)
				.map(Dish::getName).collect(Collectors.toList());
		threeHighCaloriesDishes.forEach(System.out::println);

		System.out.println("============Skipping elements using skip============");
		// Skipping elements using skip
		List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
		dishes.forEach(System.out::println);
	}
}
