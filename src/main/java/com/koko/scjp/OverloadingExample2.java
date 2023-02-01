package com.koko.scjp;

public class OverloadingExample2 {

	public static void main(String[] args) {
		add(7, 2);
		add(7.0, 2.0);
	}

	/*
	 * static void add(int a, Integer b) { System.out.println("Integer"); }
	 */

	static void add(int a, int b) {
		System.out.println("int");
	}

	static void add(Integer a, Integer b) {
		System.out.println("Integer");
	}

	static void add(Double a, Double b) {
		System.out.println("Double");
	}

	static void add(Object a, Object b) {
		System.out.println("Object");
	}
}
