package com.manauwar.designPattern.singleton;


public enum SingletonEnum {

	    INSTANCE;

	    // instance vars, constructor
	    private final TestObject test;

	    SingletonEnum()
	    {
	        // Initialize the connection
	    	test = new TestObject();
	    }

	    public TestObject getTest()
	    {
	    	//System.out.println(test);
	        return test;
	    }
	

}
