package com.yedam.java.example3;

public class CarFactory {
	//싱글톤
	private static CarFactory instance = new CarFactory();
	
	
	private CarFactory() {}
	
	public static CarFactory getInstance() {
		return instance;
	}
	
	public Car createCar() {
		return new Car();
	}
}
