package com.Java8Features;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		// TODO Auto-generated method stub
		return "green".equalsIgnoreCase(apple.getColor());
	}

}
