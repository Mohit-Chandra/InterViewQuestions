package com.venkat.lambdas;


import java.util.Arrays;
import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//arrList.forEach(e -> System.out.println(e));
		//we are passing the parameter as an argument to another function
		//System.out is an object on which instance method println is called
//		arrList.stream()
//		      // .map(e -> String.valueOf(e))
//		         .map(String::valueOf)
//		         .forEach(System.out::println);
		//Parameter can also become a target on which a method can be called
		
//		arrList.stream()
//			     .map(x -> x.toString())
//		         .map(String::toString)
//			    .forEach(System.out::println);
		/*
		 * * what happens if we have more than two parameters how we decide which should be passed
		 * */
//		System.out.println(
//							arrList.stream().reduce(0,(total,e) -> Integer.sum(e,total)));
		//For creating a method reference grab whatever is common and remove the common replace . with ::
		System.out.println(
				arrList.stream().reduce(Integer::sum));
		
		System.out.println(arrList.stream().map(String::valueOf)
					    .reduce("",(str,carry) -> carry.concat(str)));//order of parameters matter 1st is target and 2nd is argument
//				         .reduce("", String::concat));
		/*
		 *  Two limitations of method references:
		 *  1. If we are doing any manipulation of data
		 *  2. If compiler finds both static and instance methods are available
		 */
		
		System.out.println(arrList.parallelStream()
		        .filter(e -> e%2==0)
				.map(e -> e*2)
				.reduce(0,Integer::sum));
		
		
		
	}

}
