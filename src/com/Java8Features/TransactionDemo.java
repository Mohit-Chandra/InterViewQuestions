package com.Java8Features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TransactionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trader raul = new Trader("raul", "Cambridge");
		Trader mario = new Trader("mario","Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian","Patna");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian,2011,300),
				new Transaction(raul, 2012,1000),
				new Transaction(raul, 2011, 400),
				new Transaction(mario,2012,710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		//Find all Transactions in the year 2011 and sort them by value
		List<Transaction>tr2011 = 
				transactions.stream()
				.filter(transaction -> transaction.getYear()==2011)
				.sorted(Comparator.comparingInt(Transaction::getValue))
				.collect(Collectors.toList());
		
		System.out.println(tr2011);
		
		//What are all the unique cities where the traders work..?
		List<String>cities = transactions.stream()
										.map(transaction -> transaction.getTrader().getCity())
										.distinct()
										.collect(Collectors.toList());
		System.out.println(cities.toString());
										
		//Find all Traders from Cambridge and sort them by name
		List<Trader>lst_trader = transactions.stream()
								.map(Transaction::getTrader)
								.filter(trader -> trader.getCity().equalsIgnoreCase("cambridge"))
								.distinct()
								.sorted(Comparator.comparing(Trader::getName))
								.collect(Collectors.toList());
		lst_trader.forEach(trader -> System.out.println(trader.getName()));
		
		//Return a string of all traders sorted alphabetically
		
		String traders = transactions.stream()
				.map(transaction ->  transaction.getTrader().getName())
				.distinct()
				.sorted().collect(Collectors.joining());
				//.reduce("",(n1,n2)->n1+n2);
		
		System.out.println(traders);
		
		//Are any traders based in Milan
		boolean milanBased = transactions.stream()
							 .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
		System.out.println(milanBased);
		
		//Print all transaction's values from the traders living in cambridge
		
//		List<Integer>lst_values = transactions.stream()
//									.map(transaction -> transaction.getV
//											
		
		//What's the highest value of all the trnsactions..?
		Optional<Integer> highest = transactions.stream()
							.map(Transaction::getValue)
							.reduce(Integer::max);
		System.out.println(highest);
		
		//Find the transaction with the smallest value
		
		Optional<Integer> smallest = transactions.stream()
										.map(Transaction::getValue)
										.reduce(Integer::min);
		System.out.println(smallest);
											
											
							
				
		

	}

}
