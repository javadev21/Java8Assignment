package com.java8.lambda.exception;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*exception handling in java8  lambda
our requirement to write all the element of list to a file one by one.
*/

public class ExceptionHandlingInLambda {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		list.forEach(throwingConsumerWrappere(i -> writeToFile(i)));
		System.out.println("Success...");

	}

	private static void writeToFile(Integer value) throws IOException {
		File file = new File("abc.txt");
		
		//if file does not exist already then this method will throw an FileNotFoundException.
		if (!file.exists())
			throw new FileNotFoundException("File does not exist...");

		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		printWriter.println(value);
		printWriter.close();
		bufferedWriter.close();

	}

	//this method will handle FileNotFoundException
	private static <T> Consumer<T> throwingConsumerWrappere(ThrowingConsumer<T, Exception> throwingConsumer) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//exception handling code
			}
		};

	}

}
