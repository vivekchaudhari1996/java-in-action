package com.koko.java8.inaction.design.delegate;

import java.math.BigDecimal;

public class YahooFinance {
	public static BigDecimal getPrice(final String ticker) {

		BigDecimal price = null;

		if (ticker.equals("GOOGLE")) {
			price = new BigDecimal(50);
		}

		return price;
	}
}