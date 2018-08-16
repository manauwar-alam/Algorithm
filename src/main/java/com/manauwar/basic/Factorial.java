package com.manauwar.basic;

public class Factorial {

	public static void main(String[] args) {

		int number = 15;
		System.out.println("By recursive factorial of "+number + " is "+facorialRecursive(number));
		
		System.out.println("By loop factorial of "+number + " is "+factorial(number));
		
	}
	
	
	static int facorialRecursive(int number)
	{
		
		if(number == 0 )
			return 1;
		
		return number*facorialRecursive(number - 1);
		
	}
	
	static int factorial(int number)
	{
		int result = 1;
        while(number != 0){
            result = result*number;
            number--;
        }
     
        return result;


	}

}
