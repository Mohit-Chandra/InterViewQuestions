package com.string.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		System.out.println(first_non_repeat_linkedhashMap(word));
		

	}

	private static String first_non_repeat_linkedhashMap(String word) {
		// TODO Auto-generated method stub
		Map<Character,Integer>countMap=new LinkedHashMap<Character,Integer>();
		for(char ch:word.toCharArray())
		{
			countMap.put(ch,countMap.containsKey(ch)?countMap.get(ch)+1:1);
		}
		for(Entry<Character,Integer>entry:countMap.entrySet())
		{
			if(entry.getValue()==1)
				return entry.getKey().toString();
		}
		return "Not found";
	}

}
