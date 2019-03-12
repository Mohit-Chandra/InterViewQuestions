package com.venkat.lambdas;

public class Person {
	private String name;
	private int age;
	private Gender GENDER;
	public Person(String name, int age, Gender gENDER) {
		super();
		this.name = name;
		this.age = age;
		GENDER = gENDER;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGENDER() {
		return GENDER;
	}
	public void setGENDER(Gender gENDER) {
		GENDER = gENDER;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+this.name+" ,Age: "+this.age+" ";
	}
	
	

}
