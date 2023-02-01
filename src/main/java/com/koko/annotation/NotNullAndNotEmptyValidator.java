package com.koko.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NotNullAndNotEmptyValidator {
	public static List<String> validate(Object obj) {
		List<String> errors = new ArrayList<String>();

		NotNullAndNotEmpty annotations = (NotNullAndNotEmpty) obj.getClass().getAnnotation(NotNullAndNotEmpty.class);

		// if annotation not found on class then return empty list
		if (annotations != null) {

			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					if (field.get(obj) == null) {
						errors.add(field.getName() + " is null or empty");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return errors;
	}
}
