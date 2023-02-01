package com.koko.generics;

import com.koko.generics.model.Banana;
import com.koko.generics.model.Fruit;
import com.koko.generics.model.Orange;

import java.util.ArrayList;
import java.util.List;

public class InheritanceInGenerics {

	public static void useFruit(Fruit fruit) {
		System.out.println("received " + fruit);
	}

	public static void useFruitBasket(List<Fruit> fruits) {
		System.out.println("received " + fruits);

		// add another fruit after receiving basket
		fruits.add(new Orange());
	}

	public static void main(String[] args) {
		Banana banana = new Banana();
		Orange orange = new Orange();
		useFruit(banana);
		useFruit(orange);

		// 1. Collection of generic type
		List<Fruit> basketOfFruits = new ArrayList<Fruit>();
		basketOfFruits.add(banana);
		basketOfFruits.add(orange);
		useFruitBasket(basketOfFruits);

		// 2. Use basket of banana
		List<Banana> basketOfBanana = new ArrayList<>();
		basketOfBanana.add(banana);
		/*-
		 * useFruitBasket(List<Fruit>) in the type InheritanceInGenerics is not applicable for the arguments (List<Banana>)
		 *
		 * Banana extend from Fruit
		 * but
		 * List<Banana> does not extend from List<Fruit>
		 *
		 */
		// useFruitBasket(basketOfBanana); // will not compile

	}
}
