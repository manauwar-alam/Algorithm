package com.manauwar.unitTest.semaphore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.manauwar.semaphore.LoginQueueUsingSemaphore;

public class SemaphoreTestCase {

	@Test
	public void givenLoginQueue_whenReachLimit_thenBlocked() {
		
		int slots = 10;
		
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore  loginQueue =  new LoginQueueUsingSemaphore(slots);
		
		IntStream.range(0, slots).forEach(user -> executorService.execute(loginQueue::tryLogin));
		executorService.shutdown();
		
		System.out.println(loginQueue.availableSlots());
		
		assertEquals(0,loginQueue.availableSlots());
		assertFalse(loginQueue.tryLogin());	
		
	}
	
	
	
	@Test
	public void givenLoginQueue_whenLogout_thenSlotAvailable() {
		
		int slots = 10;
		
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore  loginQueue =  new LoginQueueUsingSemaphore(slots);
		
		IntStream.range(0, slots).forEach(user -> executorService.execute(loginQueue::tryLogin));
		executorService.shutdown();
		assertEquals(0,loginQueue.availableSlots(),"Available slots");
		loginQueue.logout();
	
		assertTrue(loginQueue.availableSlots() > 0,"Slots are available");
		assertTrue(loginQueue.tryLogin(),"Logged in");
	
	}

}
