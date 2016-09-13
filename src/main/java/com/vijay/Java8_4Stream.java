package com.vijay;

import java.util.Arrays;
import java.util.List;

/*SELECT max(salary), employee_name FROM Employee*/
public class Java8_4Stream {
	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

		int total = 0;
		for (Integer value : values) {
			total += value * 2;
		}
		System.out.println(total);

		// 2. stream fancy iterator.
		// map = transform
		//
		//
		//

		System.out.println(values.stream().map(e -> e * 2).reduce(0, (c, e) -> c + e));
	}
}
