package com.manauwar.basic;

public class PrimeNumberCheck {
	
	
	
	public static void main(String [] args)
	{
		
		int number = 175;
		System.out.println("Checking prime using sqrt method for number : "+ number + " - " + primeCheckSqrt(number) );
		System.out.println("Checking prime using another method for number : "+ number + " - " + isPrimeOrNot(number) );
	}
	
	
	static String primeCheckSqrt(int n)
	{
		if(n==2 || n==3)
		{
			return "Prime";
		}
		
		if(n%2 == 0)
		{
			return "Not prime";
		}
		
		int sqrt = (int)Math.sqrt(n) +1;
		
		for(int i=3; i<sqrt; i += 2)
		{
			if(n % i == 0)
			{
				return "Not prime";
			}
		}
		
		return "Prime";
	}
	
	
	
	//this method is wrong
	public static String isPrimeOrNot(int num) {
        if (num < 0) {
            return "not valid";
        }
        if (num == 0 || num == 1) {
            return "not prime";
        }
        if (num == 2 || num == 3) {
            return "prime number";
        }
        if ((num * num - 1) % 24 == 0) {
            return "prime";
        } else {
            return "not prime";
        }
    }


}
