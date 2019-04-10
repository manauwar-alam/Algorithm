package com.manauwar.designPattern.singleton;


public class SingletonDemo {
	
		
	
	//And this can be called from clients :
		public static void main(String[] args) {
			TestObject singletonEnum1 = SingletonEnum.INSTANCE.getTest();
			TestObject singletonEnum2 = SingletonEnum.INSTANCE.getTest();
			TestObject singletonEnum3 = SingletonEnum.INSTANCE.getTest();
			
			System.out.println("Singleton using enum");
			System.out.println("First call  : "+singletonEnum1);
			System.out.println("Second call : "+singletonEnum2);
			System.out.println("Third call  : "+singletonEnum3);
			//System.out.println(Singleton.getInstance().getTest());

			
			
			System.out.println("\nSingleton call using Inner Class");
			SingletonInnerClass singleton1 =  SingletonInnerClass.createInstance();
			System.out.println("First Call  : " +singleton1);
			
			SingletonInnerClass singleton2 =  SingletonInnerClass.createInstance();
			System.out.println("Second Call : " +singleton2);
			
			SingletonInnerClass singleton3 =  SingletonInnerClass.createInstance();
			System.out.println("Third Call  : " +singleton3);
			
		    }
		
}


