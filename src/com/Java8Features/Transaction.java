package com.Java8Features;

public class Transaction {
	public final Trader trader;
	public final int year;
	private final int value;
	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}
	public int getYear() {
		return year;
	}
	public int getValue() {
		return value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" + this.trader +", "+
				"year :"+this.year+", "+
				"value: "+this.value +"}";
	}
	

}
