package com.manauwar.concurrency.waitNotify;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private Queue<Integer> queue;
	private int maxSize;

	Producer(String name, Queue<Integer> queue, Integer maxSize) {

		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		
		while (true) {
			synchronized (queue) {

				while (queue.size() == maxSize) {
					try {
						System.out.println("Producer is waiting to produce as Queue is full");
						queue.wait();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				Random r = new Random();
				Integer product = r.nextInt();
				System.out.println("Producing value : "+product);
				queue.add(product);
				queue.notifyAll();

			}

		}
	}

}
