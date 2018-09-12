package com.manauwar.concurrency.waitNotify;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> queue;
	private Integer maxSize;

	public Consumer(String name, Queue<Integer> queue, Integer maxSize) {

		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (queue) {

				while (queue.isEmpty()) {
					
					System.out.println("Consumer is waiting to consume as Queue is empty");
					
					
					try {
						queue.wait();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

				}
				
				
				System.out.println("Consuming value : "+queue.remove());
				queue.notifyAll();

			}
		}

	}

}
