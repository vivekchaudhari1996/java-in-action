package com.koko.java8.inaction;

public class DefaultInterfaceExample implements Interface1, Interface2 {

	public static void main(String[] args) {
		// new DefaultInterfaceExample().log("xyz");
	}

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.log("abc");
	}
}
