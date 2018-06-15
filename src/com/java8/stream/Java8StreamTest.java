package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8StreamTest {
	
/*	requirement is to find out whether the given phone number is matching or not with any of the user's phone number
*/
	public static void main(String[] args) {
		
	List<User> users=	Arrays.asList(
			new User(101,"sam",Arrays.asList("984364677","78437437237")),
			new User(102,"black",Arrays.asList("893474773","873887485")),
			new User(102,"mike",Arrays.asList("788348374","783475848","8637465734"))
			);
	
	Optional<String> result= users.stream().map(x->x.getPhoneNumbers().stream())
			.flatMap(phoneNumberStream->phoneNumberStream.filter(
					phonNumber->phonNumber.equals("783475848"))).findAny();
	
	//if values matches then only print
	result.ifPresent(System.out::println);
	
	}

}
