package com.manauwar;

import java.util.Arrays;

public class RemovingDuplicatesArray {

	public static void main(String[] args) {

		int a[] = {1,2,2,1,3,7,4,6,4,5};
		removeDuplicates(a);
		
		
	}
	
	public static void removeDuplicates(int [] withDuplicates)
	{
		Arrays.sort(withDuplicates);
		System.out.println("Data with duplicates : "+Arrays.toString(withDuplicates));
		
		int [] withoutDuplicates = new int[withDuplicates.length];
		
		int previous = withDuplicates[0];
		withoutDuplicates[0] = previous;
		
		for(int i = 1; i < withDuplicates.length; i++)
		{
			int num = withDuplicates[i];
			if(num != previous)
			{
				withoutDuplicates[i] = num;
			}
			previous = num;
		}
		
		System.out.println("Data without duplicates : "+Arrays.toString(withoutDuplicates));
	}

}
