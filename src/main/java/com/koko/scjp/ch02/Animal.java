package com.koko.scjp.ch02;

public class Animal {
	static void doStuff() {
		System.out.print("a ");
	}

	public static void main(String[] args) {
		Animal[] a = { new Animal(), new Dog(), new Animal() };
		for (int x = 0; x < a.length; x++) {
			a[x].doStuff(); // invoke the static method
		}

		System.out.println("\nInvoking overriding methods");

		for (int x = 0; x < a.length; x++) {
			a[x].doStuff2();
		}
	}

	void doStuff2() {
		System.out.print("a ");
	}
}

class Dog extends Animal {
	static void doStuff() { // it's a redefinition,
		// not an override
		System.out.print("d ");
	}

	void doStuff2() {
		System.out.print("d ");
	}
}
