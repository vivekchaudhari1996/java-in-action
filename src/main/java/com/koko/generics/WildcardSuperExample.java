package com.koko.generics;

import com.koko.generics.model.Banana;
import com.koko.generics.model.Fruit;
import com.koko.generics.model.GreenBanana;
import com.koko.generics.model.Orange;

import java.util.ArrayList;
import java.util.List;

public class WildcardSuperExample {

	public static <T> void copy(List<T> src, List<T> target) {
		for (T e : src) {
			target.add(e);
		}
	}

	/*-
	 * banana can be copied to basket of fruits
	 * banana can be copied to  basket of banana
	 * banana can be copied to any super class of banana
	 *
	 * basket of fruits can have banana but basket of banana can't have other fruits
	 *
	 */
	public static <T> void genericCopy(List<T> src, List<? super T> target) {
		for (T e : src) {
			target.add(e);
		}
	}

	public static void main(String[] args) {
		Banana banana = new Banana();
		Orange orange = new Orange();

		// Case:- 1
		List<Fruit> basket1 = new ArrayList<>();
		basket1.add(banana);
		basket1.add(orange);

		List<Fruit> fruitBasket = new ArrayList<>();

		// copy data from basket1 to fruitBasket
		copy(basket1, fruitBasket);
		System.out.println("Elements in fruitBasket after copy :" + fruitBasket);

		// Case:- 2
		List<Banana> basketOfBanana = new ArrayList<>();
		basketOfBanana.add(banana);

		fruitBasket.clear();

		/*-
		 * copy data from basketOfBanana to fruitBasket
		 * Will NOT COMPILE !!!
		 * The method copy(List<T>, List<T>) in the type WildcardExample is not applicable for the arguments (List<Banana>, List<Fruit>)
		 */
		// copy(basketOfBanana, fruitBasket);

		// FIX
		genericCopy(basketOfBanana, fruitBasket);
		System.out.println("Elements in basket2 after copy :" + fruitBasket);

		List<GreenBanana> greenBananaBasket = new ArrayList<>();
		greenBananaBasket.add(new GreenBanana());
		// genericCopy(basketOfBanana, greenBananaBasket); // NOT COMPILE
		genericCopy(greenBananaBasket, basketOfBanana);
		System.out.println("Elements in basketOfBanana after copy :" + basketOfBanana);
	}
}
