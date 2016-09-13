package com.vijay;

public class Java8_3DefauldMethod implements vehicle, fourWheeler {

	public void print() {
		vehicle.super.print();
	}
}

interface vehicle {
	default void print() {
		System.out.println("I am a vehicle!");
	}
}

interface fourWheeler {
	default void print() {
		System.out.println("I am a four wheeler!");
	}
}
