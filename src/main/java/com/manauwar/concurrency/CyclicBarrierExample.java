package com.manauwar.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run()
			{
				//this task will be executed once all thread reaches barrier
				System.out.println("All parties has arrived at barrier, lets play");
			}
			
			
		});
		
		
		Thread t1 = new Thread(new Task(cb), "Thread1");
		Thread t2 = new Thread(new Task(cb), "Thread2");
		Thread t3 = new Thread(new Task(cb), "Thread3");
		
		t1.start();
		t2.start();
		t3.start();
		
		
		

	}

}


class Task implements Runnable
{

	private CyclicBarrier cyclicBarrier;
	
	public Task(CyclicBarrier barrier) {

		this.cyclicBarrier = barrier;
	}
	
	@Override
	public void run() {

		try {
			
			System.out.println(Thread.currentThread().getName()+" is waiting on barrier");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" is waiting on barrier");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	
	
	
	
}
