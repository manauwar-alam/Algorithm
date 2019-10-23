package com.manauwar;

public class SampleTest {

	public static void main(String[] args) {

		
		System.out.println("Current Thread Name : "+Thread.currentThread().getName());
		
		Runnable myRunnable1 = () -> {
			
				System.out.println("Current Thread Name : "+Thread.currentThread().getName());
		}; 
		
		
Runnable myRunnable2 = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Current Thread Name : "+Thread.currentThread().getName());
			}
		}; 
		
		Thread thread1 = new Thread(myRunnable1);
		thread1.start();
		
		Thread thread2 = new Thread(myRunnable2);
		thread2.start();
	}

}