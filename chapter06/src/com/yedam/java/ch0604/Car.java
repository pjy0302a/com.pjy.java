package com.yedam.java.ch0604;

public class Car {
	//필드
	String model;
	int speed;
	
	//생성자 : 값을 한번만 초기화
	Car(String model){
		this.model = model;
	}
	
	//메소드 : 여러개의 값이 필요한경우 메서드에 값을 넣는다
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for(int i=10;i<=50;i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속 : " + this.speed + "km/h)");
		}
	}
	
}
