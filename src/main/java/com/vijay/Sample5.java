package com.vijay;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import yahoofinance.YahooFinance;

public class Sample5 {

	public static StockInfo dummy = new StockInfo("", new BigDecimal(0.0));

	public static void findImperative(List<String> sysmbols) throws IOException {
		List<StockInfo> stocks = new ArrayList<StockInfo>();
		for (String sysmbol : sysmbols) {
			stocks.add(StockUtil.getPrice(sysmbol));
		}

		List<StockInfo> stocksLessThan500 = new ArrayList<StockInfo>();
		for (StockInfo stock : stocks) {
			if (StockUtil.isPriceLEssThan(new BigDecimal(500)).test(stock)) {
				stocksLessThan500.add(stock);
			}
		}

		StockInfo highPrices = dummy;
		for (StockInfo stock : stocksLessThan500) {
			highPrices = StockUtil.pickHigh(dummy, stock);
		}
		System.out.println(highPrices);

	}

	public static void main(String[] args) {
//		Timeit.code(() -> {
//			try {
//				findImperative(Tickers.symbols);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		
//		Timeit.code(() -> findFunctional(Tickers.symbols.stream()));
		Timeit.code(() -> findFunctional(Tickers.symbols.parallelStream()));
	}

	private static void findFunctional(Stream<String> symbols) {
	symbols.map(t -> {
		try {
			return StockUtil.getPrice(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	})
			.filter(StockUtil.isPriceLEssThan(new BigDecimal(500)))
			.reduce(dummy, StockUtil::pickHigh);
	}

}

class StockInfo {
	public final String ticker;
	public final BigDecimal price;

	public StockInfo(final String ticker, final BigDecimal bigDecimal) {
		super();
		this.ticker = ticker;
		this.price = bigDecimal;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ticker: %s price: %g", ticker, price);
	}

}

class StockUtil {
	public static StockInfo getPrice(final String ticker) throws IOException {
		return new StockInfo(ticker, YahooFinance.get(ticker, false).getQuote().getPrice());
	}

	public static Predicate<StockInfo> isPriceLEssThan(final BigDecimal price) {
		return stockInfo -> stockInfo.price.compareTo(price) < 0;
	}

	public static StockInfo pickHigh(final StockInfo stockInfo1, final StockInfo stockInfo2) {
		return stockInfo1.price.compareTo(stockInfo2.price) > 0 ? stockInfo1 : stockInfo2;
	}
}

class Tickers {

	public static List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN",
			"CRAY", "CSCO", "SNE");

}

class Timeit {
	public static void code(Runnable block) {
		long start = System.nanoTime();
		try {
			block.run();
		} finally {
			long end = System.nanoTime();
			System.out.println("Time taken(s): " + (end - start) / 1.0e9);
		}
	}
}