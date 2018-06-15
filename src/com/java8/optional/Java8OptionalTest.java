package com.java8.optional;

import java.util.Optional;

/*NullPointerException Handling using Java8 'Optional' Functional Interface.*/

public class Java8OptionalTest {
	
	
	public static void main(String[] args) {

		Integer value1 = null;
		Integer value2 = new Integer(10);

		// variable 'optVal1' can be non-empty or empty but it can not be null.
		// variable 'optVal2' will throw null pointer exception immediately if 'value2' is null,so we don't have to worry about null value at the time of using this variable.
		Optional<Integer> optVal1 = Optional.ofNullable(value1);
		Optional<Integer> optVal2 = Optional.of(value2);

		Integer sum = sum(optVal1, optVal2);
		System.out.println("Sum of value1 and value2 is:"+sum);

	}

	private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println("First Parameter is Present:" + a.isPresent());
		System.out.println("Second Parameter is Present:" + b.isPresent());

		//if  variable 'a' is empty then initialize 'val1' with '0'.
		Integer val1 = a.orElse(new Integer(0));
		Integer val2 = b.get();

		return val1 + val2;
	}

}
