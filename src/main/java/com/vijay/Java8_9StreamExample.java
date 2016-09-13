package com.vijay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8_9StreamExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> stream = myList.stream();
		
		Stream<Integer> highNumsSeq = stream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("Disply Numbers=" + p));

	}

}
