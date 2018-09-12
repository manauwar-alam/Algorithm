package com.manauwar;

import java.util.concurrent.CompletableFuture;

public class Test {
	String s = null;
	public Test(String s)
	{
		System.out.println("Test class called "+s);
	}
	
	public Test()
	{
		
		
	}

	public void myMethod()
	{
		System.out.println("Test class called "+s);
	}
	
	public String toString()
	{
		return s;
	}
	
	
	
	public void myMethod2()
	{
		
	String name = null;
	 
	// ...
	 
	CompletableFuture<String> completableFuture  
	  =  CompletableFuture.supplyAsync(() -> {
	      if (name == null) {
	          throw new RuntimeException("Computation error!");
	      }
	      return "Hello, " + name;
	  }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
	 
	//assertEquals("Hello, Stranger!", completableFuture.get());
	
}

}
