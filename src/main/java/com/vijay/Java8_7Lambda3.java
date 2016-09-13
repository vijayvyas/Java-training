package com.vijay;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Java8_7Lambda3 {
	private static int totalValues(List<Integer> values, Predicate<Integer> selector) {
		
		/*int total = 0;
		for (Integer number : values) {
			total += number;
		}
		return total;*/
		int total = 0;
		for (Integer number : values) {
			if(selector.test(number))
				total += number;
		}
//		return total;
		return values
				.stream()
				.filter(selector)
				.reduce(0, (c, e) -> c + e); 
		
		
	}
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
	System.out.println(totalValues(values, e -> true));	
	System.out.println(totalValues(values, e -> e % 2 == 0));	
	System.out.println(totalValues(values, e -> e % 2 != 0));	
	}

	
}
