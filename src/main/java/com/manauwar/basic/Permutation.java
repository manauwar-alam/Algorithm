package com.manauwar.basic;

public class Permutation {

	public static void main(String[] args) {
		
		permutaionOfString("", "wxyz");
	}
	
	
	public static void permutaionOfString(String perm, String word)
	{
		
		if(word.isEmpty())
		{
			System.out.println(perm+word);
		}
		else
		{
			for(int i=0; i <word.length(); i++)
			{
				permutaionOfString(perm +word.charAt(i), word.substring(0, i)+word.substring(i+1, word.length()));
			}
		}
		
		
	}

}
