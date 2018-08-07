package com.manauwar.sort;

import java.util.Arrays;

/** * Test class to sort array of integers using Quicksort algorithm in Java. * @author Javin Paul */ 



public class SortDemo{ 
	
	public static void main(String args[]) { // unsorted integer array 
		
		
		int[] unsorted = {50, 44, 6, 5, 3, 1, 8, 7, 2, 4,2,32, -5, -23};
		System.out.println("Quick sort Implementation");
		System.out.println("Unsorted array :" + Arrays.toString(unsorted)); 
		QuickSort algorithm = new QuickSort(); // sorting integer array using quicksort algorithm 
		algorithm.sort(unsorted); // printing sorted array 
		System.out.println("Sorted array :" + Arrays.toString(unsorted)); 
		
	
		//Insertion Sort Test
		System.out.println("\nInsertion sort Implementation");
		// unsorted integer array
	    int[] unsorted2 = { 32, 23, 45, 87, 92, 31, 19, -7, -23 };
	    System.out.println("integer array before sorting : " + Arrays.toString(unsorted2));
	    InsertionSort.sort(unsorted2);
	    System.out.println("integer array after sorting : " + Arrays.toString(unsorted2));
	    
	    
	    //Bubbel sor Test
	    System.out.println("\nBubble sort Implementation");
	    BubbleSort.bubbleSort(new int[] { 20, 12, 45, -9, 19, 91, 55, -23 });
	    






		
		
	} 
	
}
	


