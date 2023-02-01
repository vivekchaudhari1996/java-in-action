package com.koko.java8.inaction.streams;

import com.koko.java8.inaction.streams.model.Trader;
import com.koko.java8.inaction.streams.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTransactionExample {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Find all transactions in the year 2011 and sort them by value (small to
		// high).
		System.out.println("\n1. Find all transactions in the year 2011 and sort them by value (small to high).");
		List<Transaction> sortedTransaction = transactions.stream().filter(d -> d.getYear() == 2011)
				.collect(Collectors.toList());
		sortedTransaction.sort((a, b) -> a.getValue() - b.getValue());
		sortedTransaction.forEach(System.out::println);

		// What are all the unique cities where the traders work?
		System.out.println("\n2. What are all the unique cities where the traders work?");
		transactions.stream().map(d -> d.getTrader().getCity()).distinct().forEach(System.out::println);

		// Find all traders from Cambridge and sort them by name.
		System.out.println("\n3. Find all traders from Cambridge and sort them by name.");
		transactions.stream().filter(d -> d.getTrader().getCity().equals("Cambridge")).map(d -> d.getTrader().getName())
				.distinct().sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList())
				.forEach(System.out::println);

		/*
		 * Return a string of all traders� names sorted alphabetically. 5. Are any
		 * traders based in Milan? 6. Print all transactions� values from the traders
		 * living in Cambridge. 7. What�s the highest value of all the transactions?
		 * 8. Find the transaction with the smallest value
		 */
	}
}
