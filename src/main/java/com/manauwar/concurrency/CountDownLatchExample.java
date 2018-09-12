package com.manauwar.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	/* 
	 * One of the disadvantage of CountDownLatch is that its not reusable 
	 * once count reaches to zero you can not use CountDownLatch any more, 
	 * but don't worry Java concurrency API has another concurrent utility 
	 * called CyclicBarrier for such requirements.
	 */

	public static void main(String[] args) {

		final CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationtService = new Thread(new Service("ValidationService", 1000, latch));
		
		cacheService.start();
		alertService.start();
		validationtService.start();
		
		//application should not start processing any thread until all service is up and ready to do job
		
		try {
			latch.await();
			
			System.out.println("All services are up, Application is starting now");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


class Service implements Runnable
{
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;
	
	public Service(String name, int timeToSart, CountDownLatch latch) {

	this.name = name;
	this.timeToStart = timeToSart;
	this.latch = latch;
		
	}
	

	@Override
	public void run() {
		
		
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name+" is Up");
		latch.countDown();  //reduce of count down latch by 1
		
	}
	
	
	
}
