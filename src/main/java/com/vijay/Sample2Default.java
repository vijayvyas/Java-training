package com.vijay;

//Interfaces have default methods.
//1. default methods are automatically inherited
//2. Can  be overwrite
// 3. class hierarchy rule 
// 4. collision handling on consumer
// diff b/w abstract vs interface
// abstract class have states
// can not inherit more then one

interface Fly {
	default public void takeOff() {
		System.out.println("Fly::takeOff");
	}

	default public void turnOn() {
		System.out.println("Fly::turnOn");
	}

	default public void cruise() {
		System.out.println("Fly::cruise");
	}

	default public void land() {
		System.out.println("Fly::land");
	}
}

interface Sale {
	default public void cruise() {
		System.out.println("Sale::cruise");
	}

}

interface FastFly extends Fly {
	default public void takeOff() {
		System.out.println("FastFly::takeOff");
	}
}

class Vehicle1 {
	public void land() {
		System.out.println("Vehicle::land");
	}
}

class SeaPlan extends Vehicle1 implements FastFly, Sale {

	@Override
	public void cruise() {
		// TODO Auto-generated method stub
		FastFly.super.cruise();
	}

}

public class Sample2Default {

	public void use() {
		SeaPlan seaPlan = new SeaPlan();
		seaPlan.takeOff();
		seaPlan.turnOn();
		seaPlan.cruise();
		seaPlan.land();
	}

	public static void main(String[] args) {

		new Sample2Default().use();
	}

}
