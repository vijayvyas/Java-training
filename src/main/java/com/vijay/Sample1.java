package com.vijay;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Sample1 {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		// System.out.println(values);

		// 1 self inflicted
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
		// 2. simpler
		for (Integer value : values) {
			System.out.println(value);
		}
		// both are external itrater
		// 3 internal iterator.
		values.forEach(new Consumer<Integer>() {
			public void accept(Integer Value) {
				System.out.println(Value);
			}
		});
		// 4. still more refined
		 values.forEach((Integer value) -> System.out.println(value));
//	5
		 values.forEach((value) -> System.out.println(value));
//	6	accepting and forwarding, thats it. why to do this.
		 values.forEach(value -> System.out.println(value));
//	7
		 values.forEach(System.out::println);// Invoke dynamic

		// functional interfaces single abstract method with the parameter
		// coming in.
		// fundamentally we are moving imperative to declarative style.

		// case 2
		// 1.
		int total = 0;
		for (Integer value : values) {
			total += value * 2;
		}
		 System.out.println(total);

		// 2. stream fancy iterator.
		//map = transform
//		 
//		 
//		 
		 
		System.out.println(values.stream().map(e -> e * 2).reduce(0, (c, e) -> c + e));

		Supplier<Integer> sup =  new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return 10;
			}
		}; 
		
	}
}
