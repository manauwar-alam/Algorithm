package com.manauwar.semaphore;

import java.util.concurrent.Semaphore;;



	
	public class LoginQueueUsingSemaphore
	{
		
		private Semaphore semaphore;
		
		public LoginQueueUsingSemaphore(int slotLimit)
		{
			semaphore = new Semaphore(slotLimit);
		}
		
		
		public boolean tryLogin()
		{
			System.out.println("acquiring semaphore");
			return semaphore.tryAcquire();
		}
		
		public void logout()
		{
			System.out.println("\nreleasing semaphore\n");
			semaphore.release();
		}
		
		
		public int availableSlots()
		{
			
			return semaphore.availablePermits();
		}
		
		
		
	}
	
	
