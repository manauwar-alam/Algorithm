package com.manauwar.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

		Thread producer = new Thread(() -> {

			for (int i = 0; i <= 10; i++) {
				try {

					System.out.println("Produced : " + i);
					queue.put(i);
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread consumer = new Thread(() -> {

			while(true)
			{
			try {

				System.out.println("Consumed : " + queue.take());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}

		});

		producer.start();
		consumer.start();

	}

}
