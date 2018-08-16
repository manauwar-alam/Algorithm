package com.manauwar;

public class MethodCallTest {

	public static void main(String[] args) {
		
		method(null);

	}
	
	
	
	public static void method(Exception e)
	{
		System.out.println("Inside Exception");
	}

	public static void method(Object e)
	{
		System.out.println("Inside Object");
	}
	
	public static void method(ArithmeticException e)
	{
		System.out.println("Inside ArithmeticException");
	}
}
