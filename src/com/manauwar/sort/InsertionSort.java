package com.manauwar.sort;

public class InsertionSort {

	public static void sort(int[] unsorted) {
	    for (int i = 1; i < unsorted.length; i++) {
	      int current = unsorted[i];
	      int j = i;

	      // create right place by moving elements
	      while (j > 0 && unsorted[j - 1] > current) {

	        // move
	        unsorted[j] = unsorted[j - 1];
	        j--;
	      }

	      // found the right place, insert now
	      unsorted[j] = current;
	    }
	  }
	}


