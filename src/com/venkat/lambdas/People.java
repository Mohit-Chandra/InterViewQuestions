package com.venkat.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class People {

	public static List<Person> createPeople(){
		return Arrays.asList(
				new Person("Mohit",22,Gender.MALE),
				new Person("Rathin", 20, Gender.MALE),
				new Person("Sara", 20, Gender.FEMALE),
				new Person("Aarush", 20, Gender.MALE),
				new Person("Sara", 15, Gender.FEMALE),
				new Person("Gabbu", 28, Gender.MALE),
				new Person("Priya", 20, Gender.FEMALE)
				);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		List<Person> people = createPeople();
		Map<String, List<Person>> hMap = new HashMap();
//		List<Person> arrPerson = null;
//		for(Person p:people)
//		{
//			
//			if(hMap.containsKey(p.getName())) {
//				if(arrPerson!=null)
//				arrPerson.add(p);
//				hMap.put(p.getName(),arrPerson);
//			}
//			else 
//			{
//					arrPerson = new ArrayList();
//					arrPerson.add(p);
//					hMap.put(p.getName(),arrPerson);
//			}
//		}
//		
		System.out.println(
				people.stream()
					  .collect(Collectors.groupingBy(Person::getName))
				);
		
//		for(Entry<String, List<Person>> entry:hMap.entrySet()) {
//			System.out.println(entry);
//		}
		
	}

}
