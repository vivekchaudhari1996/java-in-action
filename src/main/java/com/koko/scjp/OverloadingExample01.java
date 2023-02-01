package com.koko.scjp;

import java.util.Collection;
import java.util.HashSet;

public class OverloadingExample01 {
	public static void main(String[] args) {
		Collection<?> c = new HashSet<>();

		OverloadingExample01.A a = new OverloadingExample01().new A();

		/*
		 * in case of overloading reference type matters method with collection type
		 * parameter will execute
		 */
		a.take(c);

		OverloadingExample01.A b = new OverloadingExample01().new B();
		b.take(c);
	}

	class A {
		void take(Collection<?> c) {
			System.out.println("Collection with HashSet");
		}

		void take(HashSet<?> s) {
			System.out.println("Method with HashSet");
		}
	}

	class B extends A {

		void take(HashSet<?> s) {
			System.out.println("Method in B with HashSet");
		}
	}
}
