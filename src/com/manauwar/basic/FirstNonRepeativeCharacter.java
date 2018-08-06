package com.manauwar.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class FirstNonRepeativeCharacter {

	public static void main(String[] args) {
		
		getFirstNonRepeatativeCharacter("howhiareyou");
		System.out.println("First Non Repeating Character : "+ nonRepeativeCharMehtod2("howhiareyou"));

	}
	
	
	
	public static void getFirstNonRepeatativeCharacter(String word)
	{
		
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		for(char c : word.toCharArray())
		{
			map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
		}
		
		
		Character c = null;
		
		for(Entry<Character,Integer> entry : map.entrySet())
		{
			if(entry.getValue() == 1)
			{
				c = entry.getKey();
				 break;
			}
		}
		
		System.out.println("First Non Repeating Character : "+c);
		
	}




public static char nonRepeativeCharMehtod2(String word)
{
	
	HashMap<Character,Integer> scoreboard = new HashMap<>();
    
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (scoreboard.containsKey(c)) {
            scoreboard.put(c, scoreboard.get(c) + 1);
        } else {
            scoreboard.put(c, 1);
        }
    }
    // since HashMap doesn't maintain order, going through string again
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (scoreboard.get(c) == 1) {
            return c;
        }
    }
    throw new RuntimeException("Undefined behaviour");
}
	
}

