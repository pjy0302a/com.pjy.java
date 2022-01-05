package com.yedam.java.example3;

public class Car {
	//필드
	private static int serial=1000; 
	private int carNumber; //자동차번호

	//생성자
	Car(){
		serial++;
		carNumber = serial;
	}
	//메소드
	public static int getSerial() {
		return serial;
	}
	public static void setSerial(int serial) {
		Car.serial = serial;
	}
	public int getNumberId() {
		return carNumber;
	}
	public void setNumberId(int numberId) {
		this.carNumber = numberId;
	}
	
}
