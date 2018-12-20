package com.manauwar.basic;

public class BitwiseRightShiftSigned {

	public static void main(String[] args) {

		
		for(int i=1; i<=10; i++)
		{
			
			
			System.out.print(i + " or ");
			//System.out.println();
			//decToBinary(i);
//			System.out.println(" ");
//			System.out.println(i >> 1);
		}
		
		//decToBinary(20);
	}
	
	
	
	static void decToBinary(int n) 
    { 
        // array to store binary number 
        int[] binaryNum = new int[1000]; 
   
        // counter for binary array 
        int i = 0; 
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
   
        // printing binary array in reverse order 
        for (int j = i - 1; j >= 0; j--) 
        {
            System.out.print(binaryNum[j]); 
            
        }
    } 

}
