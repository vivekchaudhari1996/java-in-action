package com.koko.java8.inaction.design.delegate;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
	private Function<String, BigDecimal> priceFinder;

	public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
		priceFinder = aPriceFinder;
	}

	public BigDecimal computeStockWorth(final String ticker, final int shares) {
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}

	public static void main(String[] args) {
		/**
		 * Passing the method reference
		 */
		final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);
		System.out.println(
				String.format("100 shares of Google worth: $%.2f", calculateNav.computeStockWorth("GOOGLE", 100)));
	}

}