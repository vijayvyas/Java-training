package com.vijay;

import java.util.Arrays;
import java.util.List;

public class Sample3 {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7);
		int result = 0;
		for (Integer value : values) {
			if(value > 3 && value % 2 == 0)
			{
				result = value * 2;
				break;
			}
		}
		System.out.println(result);
		
	System.out.println(
	values.stream()
			.filter(e -> e > 3)
			.filter(e-> e % 2 ==0)
			.map(e -> e * 2)
			.findFirst()
			.orElse(0));	
	}
}
