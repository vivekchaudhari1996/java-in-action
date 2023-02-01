package com.koko.scjp;

import java.io.*;

// superclass A
// A class doesn't implement Serializable
// interface.
class A {
	int i;

	// parameterized constructor
	public A(int i) {
		this.i = i;
	}

	// default constructor
	// this constructor must be present
	// otherwise we will get runtime exception
	public A() {
		i = 50;
		System.out.println("A's class constructor called");
	}
}

// subclass B
// implementing Serializable interface
class B extends A implements Serializable {
	int j;

	// parameterized constructor
	public B(int i, int j) {
		super(i);
		System.out.println("B.B()");
		this.j = j;
	}
}

// Driver class
public class SerializationWithInheritanceExample {
	public static void main(String[] args) throws Exception {
		B b1 = new B(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		// Serializing B's(subclass) object
		try (FileOutputStream fos = new FileOutputStream("abc.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// Method for serialization of B's class object
			oos.writeObject(b1);
		}

		System.out.println("Object has been serialized\n");

		// Reading the object from a file
		readObject();
		readObject();
		readObject();
	}

	static void readObject() {
		// Reading the object from a file
		try (FileInputStream fis = new FileInputStream("abc.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
			// Method for de-serialization of B's class object
			B b2 = (B) ois.readObject();

			System.out.println(
					"HasCode of A:" + b2.getClass().getSuperclass().hashCode() + " | HasCode of B:" + b2.hashCode());

			System.out.println("i = " + b2.i);
			System.out.println("j = " + b2.j);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
