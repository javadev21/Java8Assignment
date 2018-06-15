package com.java8.lambdaExpression;

public class Java8LambdaTest {

	public static void main(String[] args) {
		
		//creating a thread using lambda 
		Runnable runnable = ()-> System.out.println("Functional Interface Instation using lambda");
		 new Thread(runnable).start();
	}
}
