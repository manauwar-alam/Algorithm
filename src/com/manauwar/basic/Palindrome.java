package com.manauwar.basic;

public class Palindrome {
	
	public static void main(String [] args)
	{
		int number = 1122211;
		System.out.println("Palindrom or not for number : "+number+"-"+isPalindrome(number));
	}
	
	
	
	public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            System.out.println("reverse is : "+reverse);
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return true;
        }
        return false;
    }


}
