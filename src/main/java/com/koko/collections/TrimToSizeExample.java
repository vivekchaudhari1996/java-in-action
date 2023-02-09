package com.koko.collections;

import java.util.ArrayList;

public class TrimToSizeExample {

	public static void main(String args[]) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>(3);
		arrlist.add(35);
		arrlist.add(20);
		arrlist.add(25);
		arrlist.add(35);
		arrlist.add(20);
		arrlist.add(25);

		// elementData Object[5] (id=29)
		// arrlist.trimToSize();
		// elementData Object[3] (id=37)

		for (Integer number : arrlist) {
			System.out.println("Number = " + number);
		}
	}
}
