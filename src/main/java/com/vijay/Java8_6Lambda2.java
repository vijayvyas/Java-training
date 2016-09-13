package com.vijay;

import java.util.Arrays;
import java.util.List;

/*SELECT max(salary), employee_name FROM Employee*/
public class Java8_6Lambda2 {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(totalValus(values));
		System.out.println(totalEvenValus(values));
		System.out.println(totalOddValus(values));

	}

	private static int totalValus(List<Integer> values) {

		int total = 0;
		for (Integer value : values) {
			total += value;
		}
		return total;

	}
	
	private static int totalEvenValus(List<Integer> values) {

		int total = 0;
		for (Integer value : values) {
			if(value % 2 ==0 )
			total += value;
		}
		return total;

	}
	
	private static int totalOddValus(List<Integer> values) {

		int total = 0;
		for (Integer value : values) {
			if(value % 2 !=0 )
			total += value;
		}
		return total;

	}
}
