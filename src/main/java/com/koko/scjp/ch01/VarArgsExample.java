package com.koko.scjp.ch01;

public class VarArgsExample {

	public static void main(String[] args) {
		doStuff(1);
		doStuff(1, 2);
	}

	static void doStuff(int x, int... doArgs) {
	}
}
