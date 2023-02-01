package com.koko.annotation;

import java.util.List;

public class TestAnnotation {

	public static void main(String[] args) {
		Employee emp = new Employee("Sandeep", null);

		List<String> errors = NotNullAndNotEmptyValidator.validate(emp);

		for (String error : errors) {
			System.out.println(error);
		}
	}
}
