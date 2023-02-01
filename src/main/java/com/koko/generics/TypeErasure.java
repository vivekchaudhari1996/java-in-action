package com.koko.generics;

import java.util.ArrayList;
import java.util.List;

interface Event<T> {
}

/**
 * <pre>
 * - Effects of erasures and related gotchas
 * 		- parametrized types can't be primitives
 * 		- can't instantiate parameteric types - multiple parametrized interfaces restriction
 * 		- Still can result in runtime exceptions - backward compatibility
 * 		- unboxing
 * 		- mixed with autoboxing, can get confusing
 * 		- static fields are not what we may think they are
 * 		- use caution with equality
 * </pre>
 *
 * @author sandeep
 */
public class TypeErasure {

	/**
	 * <pre>
	 * Can't instantiate parametric types
	 * </pre>
	 */
	public static <T> void use(T instance) {
		// new T(); // not allowed, can't instantiate the type
	}

	@SuppressWarnings("unchecked") // legacy code
	public static void foo(List nums) {
		nums.add(1.0);
	}

	public static <T> T getMatching(T matcher) {
		// assume not found.
		return null;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		// list.add(1.0); // not allowed,
		// but the following is not stopped by the compiler

		try {
			foo(list);
			int value = list.get(0); // Runtime ClassCastException
			System.out.println("value :" + value);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// unboxing null to Integer using intValue method
		try {
			int result = getMatching(1); // Runtime NullPointerException
			System.out.println("result :" + result);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		TypeErasure instance = new TypeErasure();

		MyList<Integer> list1 = new MyList<>();
		MyList<Integer> list2 = new MyList<>();
		MyList<Double> list3 = new MyList<>();

		System.out.println("list2.getCount() :" + list2.getCount());

		// it should print 1 but static fields NOT different for each parametric type
		System.out.println("list3.getCount() :" + list3.getCount());

		// Notice the class name here does not include any parametric type
		// System.out.println(MyClass<Integer>.getCount());
		System.out.println("MyClass.getCount() " + MyList.getCount());
	}

	static class MyList<T> {
		private static int count; // Not different for each parametric type

		public MyList() {
			count++;
		}

		public static int getCount() {
			return count;
		}
	}
}

class MyEvent implements Event<String> {
}

/**
 * <pre>
 * multiple parameterized interfaces restriction
 * 		- you can't implement same interface again in java this is valid here as well due to type erasure
 * </pre>
 */
// class MyEvent2 implements Event<String>, Event<Integer> {} // not allowed
