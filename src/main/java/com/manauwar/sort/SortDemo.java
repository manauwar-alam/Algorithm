package com.manauwar.sort;

import java.util.Arrays;

/** * Test class to sort array of integers using Quicksort algorithm in Java. * @author Javin Paul */ 



public class SortDemo{ 
	
	public static void main(String args[]) { // unsorted integer array 
		
		//Quick sort Recursive Test
		int[] unsorted = {50, 44, 6, 5, 3, 1, 8, 7, 2, 4,2,32, -5, -23};
		System.out.println("Quick sort Implementation");
		System.out.println("Unsorted array :" + Arrays.toString(unsorted)); 
		QuickSort algorithm = new QuickSort(); // sorting integer array using quicksort algorithm 
		algorithm.sort(unsorted); // printing sorted array 
		System.out.println("Sorted array :" + Arrays.toString(unsorted)); 
		
		
		//Quick sort iterative
		
		System.out.println("\nQuick sort Iterative Implementation");
	        System.out.println("Unsorted array : " + Arrays.toString(unsorted));

	        QuickSortIterative.iterativeQsort(unsorted);
	        System.out.println("Sorted array : " + Arrays.toString(unsorted));

		
		
	
		//Insertion Sort Test
		System.out.println("\nInsertion sort Implementation");
		// unsorted integer array
	    int[] unsorted2 = { 32, 23, 45, 87, 92, 31, 19, -7, -23 };
	    System.out.println("integer array before sorting : " + Arrays.toString(unsorted2));
	    InsertionSort.sort(unsorted2);
	    System.out.println("integer array after sorting : " + Arrays.toString(unsorted2));
	    
	    
	    //Bubbel sort Test
	    System.out.println("\nBubble sort Implementation");
	    BubbleSort.bubbleSort(new int[] { 20, 12, 45, -9, 19, 91, 55, -23 });
	    BubbleSort.bubbleSortImproved(new int[] { 20, 12, 45, -9, 19, 91, 55, -23 });
	    
	    
	    //counting sort
	    
	    System.out.println("\nCounting sort in Java");
	    int[] input = { 60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40 };
	    int k = 60;

	    System.out.println("integer array before sorting");
	    System.out.println(Arrays.toString(input));

	    // sorting array using Counting Sort Algorithm
	   CountingSort.sort(input, k);

	    System.out.println("integer array after sorting using counting sort algorithm");
	    System.out.println(Arrays.toString(input));	
	    
	    
	    //Mege sort Test
	    
	    int arr[] = {12, 11, 13, 5, 6, 7,11 ,23, 32, 2};
	    
        System.out.println("\n\nGiven Array For Merge Sort");
        MergeSort.printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        MergeSort.printArray(arr);
        
       
        
        int arr2[] = {12, 11, 13, 5, 6, 7,11,67,14, 80,65 };
        int n = arr2.length;
     
        System.out.printf("\nGiven array for Merge Sort Iterative is \n");
        MergeSort.printArray(arr2, n);
     
        MergeSort.sortIterative(arr2, n);
     
        System.out.printf("\nSorted array is \n");
        MergeSort.printArray(arr2, n);
	    
	    
	} 
	
}
	


