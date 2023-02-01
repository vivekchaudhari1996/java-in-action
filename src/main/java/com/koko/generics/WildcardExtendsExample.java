package com.koko.generics;

import java.util.List;

public class WildcardExtendsExample {

	public static <T extends Comparable<T>> void copy(List<T> source, List<T> target) {
		// the below line works only if <T extends Comparable>
		if (target.get(0).compareTo(source.get(0)) != 0) {
		}
	}

	public static void main(String[] args) {
		MyList<Integer> list = new MyList<Integer>();
		list.add(1);
		list.add(2);
		// list.add(1.0); // this line will not compile

	}

	static class MyList<T> {
		public void add(T element) {
			System.out.println("adding...");
		}
	}
}
