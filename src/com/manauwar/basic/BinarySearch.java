package com.manauwar.basic;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int input[] = {33,23,98,100,45,60,73,81,87,39};
		int number = 98;
		
		
		//binary search only works on sorted inputs
		Arrays.sort(input);
		
		System.out.println("Input to be searched : ");
		for(int i=0;i<input.length;i++)
			System.out.print(input[i]+",");
		System.out.println();
		
	int searched = 	binarySearch(input, number);
	
	System.out.println(searched);

	
	//***********************************************************************************
	
	int low =0;
	int high = input.length -1;

	int searchedByRecursive = binarySearchRecursive(input,low, high, number);
	
	System.out.println(searchedByRecursive);
			
	}
	
	
	
	static int binarySearch(int input[], int number)
	{
		
		int low = 0;
		int high = input.length -1;
		
		while(high >= low)
		{
			int middle = (low+high)/2;
			
			if(input[middle] == number)
				return middle;
			
			else if(number < input[middle])
				high = middle -1;
			
			else if(number > input[middle] )
				low = middle+1;
		}
		
		return -1;
			
	}
	
	
	static int binarySearchRecursive(int input[], int low, int high, int number)
	{
		if(high >= low)
		{
			int middle = (low+high)/2;
			
			if(input[middle] == number)
				return middle;
			else if(number < input[middle])
			{
				high = high-1;
				return binarySearchRecursive(input, low, high, number);
			}
			else if(number > input[middle])
			{
				low = low+1;
				return binarySearchRecursive(input, low, high, number);
			}
				
		}
		
		return -1;
	}

}
