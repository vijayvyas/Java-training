package com.vijay;

import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Test {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7);

		int total = 0;
		for (Integer integer : values) {

		}

	}
}
interface HelloWorld {
	public int setValue(Integer i);

	default public void print(Integer i) {
		System.out.println(i);

	}
}

class HelloWorldTest {

	public static void main(String[] args) {
		HelloWorld test = e -> e + 2;
		System.out.println(test.setValue(10));
	}
}
