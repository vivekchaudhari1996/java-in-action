package com.koko.java8.inaction.streams;

import com.koko.java8.inaction.streams.model.Dish;
import com.koko.java8.inaction.streams.util.MenuProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExternalAndInternalIteration {

	public static void main(String[] args) {
		List<Dish> menu = MenuProvider.getMenu();

		System.out.println("============Dish Names using external iteration============");

		// external iteration
		List<String> dishNames = new ArrayList<>();
		for (Dish dish : menu) {
			dishNames.add(dish.getName());
		}
		dishNames.forEach(System.out::println);

		System.out.println("============Dish Names using internal iteration============");

		// internal iteration
		dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());
		dishNames.forEach(System.out::println);
	}
}
