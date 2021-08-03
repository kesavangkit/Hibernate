package com.Hibernate.Constant;

public class GenericHelper {

	public static boolean isBlank(String value) {
		return ((value == null) || (value.length() == 0));
	}
}