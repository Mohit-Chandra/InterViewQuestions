package com.Java8Features;

public class Apple {
	int weight;
	String color;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return weight+" "+color;
	}
	

}
