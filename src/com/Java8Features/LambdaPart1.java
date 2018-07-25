package com.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Apple> inventory = Arrays.asList(new Apple(80,"Green"),
				                              new Apple(90,"Red"),
				                              new Apple(100,"Pink"));
	   
		List<Apple> heavyApples=	 filterApple(inventory,new AppleHeavyWeightPredicate());
		System.out.println(heavyApples);
		List<Apple> greenApples=	 filterApple(inventory,new AppleGreenColorPredicate());
		System.out.println(greenApples);

	}

	private static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p) {
		// TODO Auto-generated method stub
		List<Apple> result = new ArrayList();
		for (Apple apple : inventory) {
			if(p.test(apple))
				result.add(apple);
		}
		return result;
	}

}
