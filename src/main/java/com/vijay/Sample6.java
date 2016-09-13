package com.vijay;

@FunctionalInterface
public interface Sample6 {

	
	void method1(String str);

	static void print(String str) {
		System.out.println("Printing " + str);
	}
	/*default String toString(){
		return "i1";
	}*/
}
