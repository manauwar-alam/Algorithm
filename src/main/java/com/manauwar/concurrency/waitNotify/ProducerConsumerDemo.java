package com.manauwar.concurrency.waitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {

	public static void main(String[] args) {

		System.out.println("Producer consumer Demo ");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Producer producer = new Producer("PRODUCER", queue, 10);
		Consumer consumer = new Consumer("CONSUMER", queue, 10);
		
		producer.start();
		consumer.start();

	}

}
