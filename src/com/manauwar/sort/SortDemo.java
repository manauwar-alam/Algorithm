package com.manauwar.sort;

import java.util.Arrays;

/** * Test class to sort array of integers using Quicksort algorithm in Java. * @author Javin Paul */ 



public class SortDemo{ 
	
	public static void main(String args[]) { // unsorted integer array 
		
		
		int[] unsorted = {50, 44, 6, 5, 3, 1, 8, 7, 2, 4,2,32};
		System.out.println("Quick sort Implementation");
		System.out.println("Unsorted array :" + Arrays.toString(unsorted)); 
		QuickSort algorithm = new QuickSort(); // sorting integer array using quicksort algorithm 
		algorithm.sort(unsorted); // printing sorted array 
		System.out.println("Sorted array :" + Arrays.toString(unsorted)); 
		
	
	} 
	
}
	


