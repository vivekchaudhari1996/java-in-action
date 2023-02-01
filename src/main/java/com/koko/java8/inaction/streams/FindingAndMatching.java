package com.koko.java8.inaction.streams;

import com.koko.java8.inaction.streams.model.Dish;
import com.koko.java8.inaction.streams.util.MenuProvider;

import java.util.List;

public class FindingAndMatching {

	public static void main(String[] args) {
		List<Dish> menu = MenuProvider.getMenu();

		matching(menu);
	}

	public static void matching(List<Dish> menu) {
		// anyMatch
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("Menu contains vegetarian dishes");
		}

		// allMatch
		if (!menu.stream().allMatch(Dish::isVegetarian)) {
			System.out.println("Not all dishes are vegetarian dishes");
		}
		// noneMatch
		if (menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
			System.out.println("There is no dish with more than 1000 calories");
		}
	}
}
