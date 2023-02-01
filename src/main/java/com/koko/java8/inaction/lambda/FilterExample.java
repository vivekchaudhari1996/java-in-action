package com.koko.java8.inaction.lambda;

import com.koko.java8.inaction.lambda.model.Person;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
	public static List<Person> createPerson() {
		return Arrays.asList(new Person("Sara", Person.Gender.FEMALE, 34),
				new Person("Sara", Person.Gender.FEMALE, 32),
				new Person("Sandeep", Person.Gender.MALE, 34),
				new Person("Pooja", Person.Gender.FEMALE, 32),
				new Person("Sachin", Person.Gender.MALE, 31),
				new Person("Vinay", Person.Gender.MALE, 33),
				new Person("Vivaan", Person.Gender.MALE, 5)
		);
	}

	public static void main(String[] args) {

		//findFirst
		String name = createPerson().parallelStream()
				.filter(person -> person.getAge() > 32)
				.map(Person::getName)
				.findFirst()
				.orElse("Not found");

		System.out.println(name);

		//findAny
		name = createPerson().parallelStream()
				.filter(person -> person.getAge() > 30)
				.map(Person::getName)
				.findAny()
				.orElse("Not found");

		System.out.println(name);
	}
}
