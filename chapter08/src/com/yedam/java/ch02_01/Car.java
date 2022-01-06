package com.yedam.java.ch02_01;

public class Car {
	Tire frontLeftTire = new HankokTire();
	Tire frontRightTire = new HankokTire();
	Tire backLeftTire = new HankokTire();
	Tire backRightTire = new HankokTire();
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
}
