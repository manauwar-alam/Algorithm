package com.manauwar.sort;

import java.util.Arrays;

public class BubbleSort {
	
	
	
	/*
     * This method sort the integer array using bubble sort algorithm
     */
    public static void bubbleSort(int[] numbers) {
        System.out.printf("Unsorted array in Java :%s %n", Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length -1; j > i; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j-1);
                }
            }
        }

        System.out.printf("Sorted Array using Bubble sort algorithm :%s %n", Arrays.toString(numbers));
    }
    
   
    
    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
 
    
    public static void bubbleSortImproved(int[] number) {        
        boolean swapped = true;
        int last = number.length - 2;

        // only continue if swapping of number has occurred
        while (swapped) {
            swapped = false;
            
            for (int i = 0; i <= last; i++) {
                if (number[i] > number[i + 1]) {
                    
                    // pair is out of order, swap them
                    swap(number, i, i + 1);
                    
                    swapped = true; // swapping occurred
                }
            }

            // after each pass largest element moved to end of array
            last--;
        }
        
        System.out.printf("Sorted Array using Bubble sort Improved :%s %n", Arrays.toString(number));

    }



    
}


